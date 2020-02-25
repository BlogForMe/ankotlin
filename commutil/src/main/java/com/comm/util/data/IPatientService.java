package com.comm.util.data;

import com.comm.util.bean.Patient;
import com.comm.util.speak.ISpeakManager;

public interface IPatientService {
    void setCurrentPatient(Patient patient);

     Patient getPatient();

    void setSpeakManager(ISpeakManager mSpeakManager);

    ISpeakManager getSpeakManager();

}
