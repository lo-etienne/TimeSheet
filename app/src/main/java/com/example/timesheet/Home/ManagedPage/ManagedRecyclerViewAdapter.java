package com.example.timesheet.Home.ManagedPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.timesheet.Home.ManagedPage.ManagedPagePresenter;
import com.example.timesheet.Home.ManagedPage.IManagedItemScreen;
import com.example.timesheet.R;

public class ManagedRecyclerViewAdapter extends RecyclerView.Adapter<ManagedRecyclerViewAdapter.ViewHolder>{
    private ManagedPagePresenter presenter;

    public ManagedRecyclerViewAdapter(final ManagedPagePresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public ManagedRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_managed_item, parent, false);
        return new ManagedRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ManagedRecyclerViewAdapter.ViewHolder holder, int position) {
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

    public class ViewHolder extends RecyclerView.ViewHolder implements IManagedItemScreen {

        public final View view;
        private TextView date;
        private TextView code;
        private TextView wps;
        private ImageView validate;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.date = (TextView) view.findViewById(R.id.managed_date);
            this.code = (TextView) view.findViewById(R.id.managed_code);
            this.wps = (TextView) view.findViewById(R.id.managed_wps);
            this.validate = (ImageView) view.findViewById(R.id.managed_validate);
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
                case 0: this.validate.setImageResource(R.drawable.cancel); break;
                case 1: this.validate.setImageResource(R.drawable.hourglass); break;
                case 2: this.validate.setImageResource(R.drawable.checked); break;
            }
        }
    }
}
