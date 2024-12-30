package com.kot.service.userinitiate


import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataTransferJobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        // Start the job in a background thread using coroutines
        if (params != null) {
            // Simulating a data transfer task
            simulateDataTransfer(params)
            return true
        }
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        // If the job is canceled, we return true to reschedule it if necessary
        Log.d("DataTransferJob", "Job was stopped")
        return true
    }

    private fun simulateDataTransfer(params: JobParameters) {
        // Example of a coroutine job to simulate data transfer
        // In reality, this would be an API call or large file upload
        kotlinx.coroutines.GlobalScope.launch(Dispatchers.IO) {
            try {
                // Simulate a network call or file upload
                Log.d("DataTransferJob", "Starting data transfer...")

                // Simulate a delay to mimic a network call or file transfer
                Thread.sleep(5000)  // 5 seconds delay for demo purposes

                withContext(Dispatchers.Main) {
                    Log.d("DataTransferJob", "Data transfer completed successfully")
                    jobFinished(params, false) // false means no need to reschedule
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("DataTransferJob", "Error during data transfer: ${e.message}")
                    jobFinished(params, true) // Reschedule the job in case of failure
                }
            }
        }
    }
}
