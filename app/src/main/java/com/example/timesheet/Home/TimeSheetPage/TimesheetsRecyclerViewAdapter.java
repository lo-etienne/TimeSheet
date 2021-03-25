package com.example.timesheet.Home.TimeSheetPage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.timesheet.R;

public class TimesheetsRecyclerViewAdapter extends RecyclerView.Adapter<TimesheetsRecyclerViewAdapter.ViewHolder>{
    private final TimesheetsPagePresenter presenter;

    public TimesheetsRecyclerViewAdapter(final TimesheetsPagePresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_time_sheet_item, parent, false);
        return new ViewHolder(view);
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

    public class ViewHolder extends RecyclerView.ViewHolder implements ITimesheetItemScreen {

        public final View view;

        private TextView date;
        private TextView code;
        private TextView wps;
        private ImageView validate;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
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
        public void showTimesheet(String date, String code, String wps, int validate) {
            this.date.setText(date);
            this.code.setText(code);
            this.wps.setText(wps);

            switch (validate){
                case 0: this.validate.setImageResource(R.drawable.hourglass); break;
                case 1: this.validate.setImageResource(R.drawable.checked); break;
                case 2: this.validate.setImageResource(R.drawable.cancel); break;
            }
        }
    }
}
