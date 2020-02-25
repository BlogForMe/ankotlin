package com.comm.util.data;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance(){
        return  instance;
    }

    private ServiceFactory() {
        }

    private IPatientService  mPatientService;

    public IPatientService getmPatientService() {
        if (mPatientService==null){
            return  new EmptyPatientService();
        }
        return mPatientService;
    }

    public void setmPatientService(IPatientService mPatientService) {
        this.mPatientService = mPatientService;
    }
}
