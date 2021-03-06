package com.example.timesheet.Home.TimeSheetPage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.timesheet.Home.ManagedPage.ManagedPageFragment;
import com.example.timesheet.R;

import java.util.UUID;

public class TimesheetsRecyclerViewAdapter extends RecyclerView.Adapter<TimesheetsRecyclerViewAdapter.ViewHolder>{
    private final TimesheetsPagePresenter presenter;
    private ManagedPageFragment.ISelectedTimesheet callbacks;

    public TimesheetsRecyclerViewAdapter(final TimesheetsPagePresenter presenter, ManagedPageFragment.ISelectedTimesheet callbacks) {
        this.presenter = presenter;
        this.callbacks = callbacks;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_time_sheet_item, parent, false);
        return new ViewHolder(view, callbacks);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        presenter.showTimesheetOn(holder, position);
    }

    @Override
    public int getItemCount() {
        if(presenter == null) {
            return 0;
        } else {
            return presenter.getItemCount();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ITimesheetItemScreen, View.OnClickListener {

        public final View view;
        private UUID timesheetId;
        private TextView date;
        private TextView code;
        private TextView wps;
        private ImageView validate;
        private ManagedPageFragment.ISelectedTimesheet callbacks;


        public ViewHolder(View view, ManagedPageFragment.ISelectedTimesheet callbacks) {
            super(view);
            this.view = view;
            this.callbacks = callbacks;
            view.setOnClickListener(this);
            this.date = view.findViewById(R.id.time_sheet_date);
            this.code = view.findViewById(R.id.time_sheet_code);
            this.wps = view.findViewById(R.id.time_sheet_wps);
            this.validate = view.findViewById(R.id.time_sheet_validate);
        }

        @Override
        public String toString() {
            return "";
        }

        @Override
        public void showTimesheet(UUID timesheetId, String date, String code, String wps, int validate) {
            this.timesheetId = timesheetId;
            this.date.setText(date);
            this.code.setText(code);
            this.wps.setText(wps);

            switch (validate){
                case 0: this.validate.setImageResource(R.drawable.cancel); break;
                case 1: this.validate.setImageResource(R.drawable.hourglass); break;
                case 2: this.validate.setImageResource(R.drawable.checked); break;
            }
        }

        @Override
        public void onClick(View view) {
            callbacks.onSelectedTimesheet(timesheetId);
        }
    }
}
