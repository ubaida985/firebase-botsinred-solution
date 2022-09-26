package com.example.firebase.springbootfirebasebotsinred.services;

import com.example.firebase.springbootfirebasebotsinred.entities.Schedule;
import com.example.firebase.springbootfirebasebotsinred.utilities.Preferences;
import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
@DependsOn("Firebase")
public class ScheduleService {

    private static final String COLLECTION_NAME = "schedules";

    public String saveSchedule(Schedule schedule) throws ExecutionException, InterruptedException {
        Firestore firestoreDB = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = firestoreDB.collection(COLLECTION_NAME).document(schedule.getUserID()).set(schedule);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public List<Schedule> getSchedules(String userID) throws ExecutionException, InterruptedException {
        if( !userID.equals(Preferences.userID) ){
            Preferences.lastUpdate = 0;
            Preferences.userID = userID;
        }
        Timestamp lastRead = Timestamp.ofTimeMicroseconds(Preferences.lastUpdate);
        System.out.println(lastRead);
        List<Schedule> schedules = new ArrayList<>();
       try{
           Firestore firestoreDB = FirestoreClient.getFirestore();
           ApiFuture<QuerySnapshot> future = firestoreDB.collection(COLLECTION_NAME)
                   .whereEqualTo("userID", userID)
                   .whereGreaterThan("date", lastRead)
                   .get();
           List<QueryDocumentSnapshot> documents = future.get().getDocuments();
           for (DocumentSnapshot document : documents) {
               schedules.add(document.toObject(Schedule.class));
           }
       }catch (Exception e){
           e.printStackTrace();
       }

        Preferences.lastUpdate = System.currentTimeMillis()*1000;
        return schedules;
    }

    public List<Schedule> getAllSchedules() throws ExecutionException, InterruptedException {
        List<Schedule> schedules = new ArrayList<>();
        Firestore firestoreDB = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = firestoreDB.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            schedules.add(document.toObject(Schedule.class));
        }
        return schedules;
    }
}
