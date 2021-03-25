package com.example.timesheet.Home.ManagePage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timesheet.Home.TimeSheetPage.ITimesheetItemScreen;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsPagePresenter;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsRecyclerViewAdapter;
import com.example.timesheet.R;

public class ManageRecyclerViewAdapter extends RecyclerView.Adapter<ManageRecyclerViewAdapter.ViewHolder>{
    private final ManagePagePresenter presenter;

    public ManageRecyclerViewAdapter(final ManagePagePresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public ManageRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_manage_item, parent, false);
        return new ManageRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ManageRecyclerViewAdapter.ViewHolder holder, int position) {
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

    public class ViewHolder extends RecyclerView.ViewHolder implements IManageItemScreen {

        public final View view;
        private TextView date;
        private TextView code;
        private TextView wps;
        private ImageView validate;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.date = (TextView) view.findViewById(R.id.manage_date);
            this.code = (TextView) view.findViewById(R.id.manage_code);
            this.wps = (TextView) view.findViewById(R.id.manage_wps);
            this.validate = (ImageView) view.findViewById(R.id.manage_validate);
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
