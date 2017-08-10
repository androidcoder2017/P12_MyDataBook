package com.example.a15056112.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    Button btnEdit;
    TextView tv;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference editLists;

    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firebaseDatabase = FirebaseDatabase.getInstance();
        editLists = firebaseDatabase.getReference("Lists");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bio, container, false);

        btnEdit = (Button) view.findViewById(R.id.btnFragBio);
        tv = (TextView) view.findViewById(R.id.tv);

        firebase();

       btnEdit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               LayoutInflater inflater2 = (LayoutInflater)
                       getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               final LinearLayout passPhrase = (LinearLayout) inflater2.inflate(R.layout.editpassphrase, null);
               final EditText etPassphrase = (EditText) passPhrase.findViewById(R.id.editTextPassPhrase);

               AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
               builder.setTitle("Edit Bio")
                       .setView(passPhrase)
                       .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int id) {
                               String bio = etPassphrase.getText().toString();
                               DatabaseReference dbr = editLists;
                               dbr.child("Bio").setValue(bio);
                           }
                       });

               builder.setNegativeButton("Cancel", null);
               AlertDialog alertDialog = builder.create();
               alertDialog.show();
           }
       });

        return view;
    }

    private void firebase() {
        editLists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String lists = dataSnapshot.child("Bio").getValue(String.class);
                tv.setText(lists);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
