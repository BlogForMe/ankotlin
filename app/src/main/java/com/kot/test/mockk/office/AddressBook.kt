/**
 *
 * ClassName:      Hierarchical
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/8 4:54 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/8 4:54 PM
 * UpdateRemark:   Modify the description
 */

package com.kot.test.mockk.office

interface AddressBook {
    val contacts: List<Contact>
}

interface Contact {
    val name: String
    val telephone: String
    val address: Address
}

interface Address {
    val city: String
    val zip: String
}