package com.example.firebase.springbootfirebasebotsinred.services;

import com.example.firebase.springbootfirebasebotsinred.entities.Schedule;
import com.example.firebase.springbootfirebasebotsinred.entities.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
@DependsOn("Firebase")
public class UserService {

    private static final String COLLECTION_NAME = "users";
    public List<User> getUsers() throws ExecutionException, InterruptedException {
        List<User> users = new ArrayList<>();
        Firestore firestoreDB = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = firestoreDB.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            users.add(document.toObject(User.class));
        }
        return users;
    }

    public User getUser(String userID) throws ExecutionException, InterruptedException {
        Firestore firestoreDB = FirestoreClient.getFirestore();
        User user = null;
        ApiFuture<QuerySnapshot> future = firestoreDB.collection(COLLECTION_NAME).whereEqualTo("userID", userID).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            user = document.toObject(User.class);
            break;
        }
        return user;
    }
}
