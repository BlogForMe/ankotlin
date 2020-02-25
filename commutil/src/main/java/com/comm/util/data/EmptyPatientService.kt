package com.comm.util.data

import com.comm.util.bean.Patient
import com.comm.util.speak.ISpeakManager

class EmptyPatientService : IPatientService{
    override fun getSpeakManager(): ISpeakManager? {
        return  null
    }

    override fun setSpeakManager(mSpeakManager: ISpeakManager?) {
    }


    override fun setCurrentPatient(patient: Patient?) {
    }

    override fun getPatient(): Patient? {
        return  null;
    }
}