package in.tvac.akshayejh.firebasepushnotifications;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CompaniesFragment extends android.support.v4.app.Fragment {

    private RecyclerView mCompaniesListView;

    private List<Companies> companiesList;
    private CompaniesRecyclerAdapter companiesRecyclerAdapter;

    private FirebaseFirestore mFirestore;

    public CompaniesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_companies, container, false);

        mFirestore = FirebaseFirestore.getInstance();

        mCompaniesListView = (RecyclerView) view.findViewById(R.id.companies_list_view);

        companiesList = new ArrayList<>();
        companiesRecyclerAdapter = new CompaniesRecyclerAdapter(container.getContext(), companiesList);

        mCompaniesListView.setHasFixedSize(true);
        mCompaniesListView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mCompaniesListView.setAdapter(companiesRecyclerAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        companiesList.clear();

        mFirestore.collection("Companies").addSnapshotListener(getActivity(), new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {

                    if (doc.getType() == DocumentChange.Type.ADDED) {
                        String companyId = doc.getDocument().getId();
                        Companies companies = doc.getDocument().toObject(Companies.class).withId(companyId);
                        companiesList.add(companies);
                        companiesRecyclerAdapter.notifyDataSetChanged();
                    }

                }

            }
        });

    }
}
