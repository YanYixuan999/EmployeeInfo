package sg.edu.rp.c346.employeeinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17042739 on 17/7/2018.
 */

public class EmployeeAdapter extends ArrayAdapter{
    Context parent_context;
    int layout_id;
    ArrayList<EmployeeInfo> employeeList;

    public EmployeeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<EmployeeInfo> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        employeeList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent,false);

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvSalary = rowView.findViewById(R.id.textViewSalary);

        EmployeeInfo currentEmployee = employeeList.get(position);

        String name = currentEmployee.getName();
        String title = currentEmployee.getTitle();
        float salary = currentEmployee.getSalary();

        tvName.setText(name);
        tvTitle.setText(title);
        tvSalary.setText(salary + "");

        return rowView;
    }
}
