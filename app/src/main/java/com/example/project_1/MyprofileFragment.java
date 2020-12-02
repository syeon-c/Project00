package com.example.project_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import de.hdodenhof.circleimageview.CircleImageView;
import model.UserModel;

public class MyprofileFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    String uid;
    String userName;
    String userImage;
    TextView userNameView;
    CircleImageView userImageView;
    Button adressSetting;

    MainActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (ViewGroup)inflater.inflate(R.layout.fragment_myprofile, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();

        userNameView = (TextView) view.findViewById(R.id.profile_name);
        userImageView = (CircleImageView) view.findViewById(R.id.profile_img);

        // 프로필 이름 & 사진 설정
        userNameView.setText(userName);
        Glide.with(this).load(userImage).into(userImageView);

        adressSetting = (Button) view.findViewById(R.id.adressSetting);
        adressSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setFrag(3);
            }
        });

        return view;
    }
}
