package in.tvac.akshayejh.firebasepushnotifications;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CompaniesRecyclerAdapter extends RecyclerView.Adapter<CompaniesRecyclerAdapter.ViewHolder> {

    private List<Companies> companiesList;
    private Context context;

    public CompaniesRecyclerAdapter(Context context, List<Companies> companiesList){
        this.companiesList = companiesList;
        this.context = context;
    }

    @Override
    public CompaniesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_list_item, parent, false);
        return new CompaniesRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompaniesRecyclerAdapter.ViewHolder holder, int position) {
        final String company_name = companiesList.get(position).getName();
        holder.company_name_view.setText(company_name);

        CircleImageView company_image_view = holder.company_image_view;
        Glide.with(context).load(companiesList.get(position).getImage()).into(company_image_view);

        final String company_id = companiesList.get(position).companyId;

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent sendIntent = new Intent(context, SendActivity.class);
                sendIntent.putExtra("company_id", company_id);
                sendIntent.putExtra("company_name", company_name);
                context.startActivity(sendIntent);*/

            }
        });


    }

    @Override
    public int getItemCount() {
        return companiesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;

        private CircleImageView company_image_view;
        private TextView company_name_view;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            company_image_view = (CircleImageView) mView.findViewById(R.id.company_list_image);
            company_name_view = (TextView) mView.findViewById(R.id.company_list_name);

        }
    }
}
