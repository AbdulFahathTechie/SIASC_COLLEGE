package com.example.siasc_college.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.siasc_college.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private RecyclerView festRecycler, campusRecycler, sportsRecycler;
    private GalleryAdapter festAdapter, campusAdapter, sportsAdapter;

    private DatabaseReference galleryRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        festRecycler = view.findViewById(R.id.festRecycler);
        campusRecycler = view.findViewById(R.id.campusRecycler);
        sportsRecycler = view.findViewById(R.id.sportsRecycler);

        galleryRef = FirebaseDatabase.getInstance().getReference().child("gallery");

        getFestImages();
        getCampusImages();
        getSportsImages();

        return view;
    }

    private void getFestImages() {
        galleryRef.child("FestImage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> images = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    images.add(dataSnapshot.getValue(String.class));
                }

                festAdapter = new GalleryAdapter(getContext(), images);
                festRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                festRecycler.setAdapter(festAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getCampusImages() {
        galleryRef.child("CampusImage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> images = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    images.add(dataSnapshot.getValue(String.class));
                }

                campusAdapter = new GalleryAdapter(getContext(), images);
                campusRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                campusRecycler.setAdapter(campusAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getSportsImages() {
        galleryRef.child("SportsImage").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> images = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    images.add(dataSnapshot.getValue(String.class));
                }

                sportsAdapter = new GalleryAdapter(getContext(), images);
                sportsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                sportsRecycler.setAdapter(sportsAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
