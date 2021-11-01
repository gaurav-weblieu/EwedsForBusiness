package com.eweding.ewedsbusiness;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class Gallery extends Fragment {

    ImageView imageView_add_al;
    CardView cardView_upload;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);

        imageView_add_al=view.findViewById(R.id.imageView_add_al);
        cardView_upload=view.findViewById(R.id.cardView_upload);

        imageView_add_al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        cardView_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(),AddImageToAlbum.class));
            }
        });

        return  view;
    }


    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        bottomSheetDialog.setContentView(R.layout.add_new_album);

        bottomSheetDialog.show();
    }



        public void showDialog(){
            AlertDialog.Builder imageDialog = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getLayoutInflater();
            View view=inflater.inflate(R.layout.add_new_album, null);
            EditText editText_name=view.findViewById(R.id.edit_alb_name);
            editText_name.setFocusable(true);
            if(editText_name.requestFocus()) {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
            AlertDialog a = imageDialog.create();
            a.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            a.setView(view, 0, 0, 0, 0);
            a.show();

        }

}