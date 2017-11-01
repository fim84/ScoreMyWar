package com.familyfight.stenb.scoremywar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by stenb on 2017-09-07.
 */
public class ReslutDialog extends DialogFragment{


    public interface NoticeDialogListener{
        public void onDialogPositiveClick(DialogFragment dialog, String s, int id);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    protected EditText text;
    private ArrayList<String> contests = new ArrayList<>();
    private int contest = 0;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        text = new EditText(getActivity());
        text.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setMessage(R.string.score).setMultiChoiceItems(R.array.contest,0, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int witch){
                contest = witch;
            }
        }).setView(text)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                        String s = text.getText().toString();
                        mListener.onDialogPositiveClick(ReslutDialog.this, s, contest);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        mListener.onDialogNegativeClick(ReslutDialog.this);
                    }
                });


        return builder.create();
    }

    NoticeDialogListener mListener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            mListener = (NoticeDialogListener) activity;
        }
        catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " Must implement NoticeDialogListener");
        }
    }

}
