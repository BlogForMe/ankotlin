package com.comm.util.data;

import com.comm.util.bean.Patient;
import com.comm.util.speak.ISpeakManager;

public class ServiceData  implements IPatientService{
    private Patient currentPatient;
    private ISpeakManager speakManager;
    @Override
    public void setCurrentPatient(Patient patient) {
        this.currentPatient = patient;
    }

    @Override
    public Patient getPatient() {
        return currentPatient;
    }

    @Override
    public void setSpeakManager(ISpeakManager mSpeakManager) {
        speakManager = mSpeakManager;
    }

    @Override
    public ISpeakManager getSpeakManager() {
        return speakManager;
    }
}
