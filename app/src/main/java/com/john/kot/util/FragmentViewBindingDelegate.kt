package my.com.tngdigital.common.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.john.kot.util.observerWhenCreated
import com.john.kot.util.observerWhenDestroyed
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingDelegate<T : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> T
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null

    init {
        fragment.lifecycle.observerWhenCreated {
            fragment.viewLifecycleOwnerLiveData.observe(fragment, {
                it.lifecycle.observerWhenDestroyed {
                    binding = null
                }
            })
        }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
//            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
            println("Should not attempt to get bindings when Fragment views are destroyed.")
        }
        return viewBindingFactory(thisRef.requireView()).also { this.binding = it }
    }
}
