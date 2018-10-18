package com.example.claudia.festafimdeano.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.claudia.festafimdeano.R;
import com.example.claudia.festafimdeano.constanse.FimDeAnoConstance;
import com.example.claudia.festafimdeano.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkPasticipate = findViewById(R.id.check_participate);

        this.mViewHolder.checkPasticipate.setOnClickListener(this);

        this.loadDataFromActivity();

    }


    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.check_participate) {
            if (this.mViewHolder.checkPasticipate.isChecked()) {
                this.mSecurityPreferences.storeString(FimDeAnoConstance.PRESENCE, FimDeAnoConstance.CONFIRMED_WILL_GO);
            } else {
                this.mSecurityPreferences.storeString(FimDeAnoConstance.PRESENCE, FimDeAnoConstance.CONFIRMED_WONT_GO);
            }
        }
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(FimDeAnoConstance.PRESENCE);
            if (presence.equals(FimDeAnoConstance.CONFIRMED_WILL_GO)) {
                this.mViewHolder.checkPasticipate.setChecked(true);
            } else {
                this.mViewHolder.checkPasticipate.setChecked(false);
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private static class ViewHolder {
        CheckBox checkPasticipate;
    }
}
