package com.example.markus.quakewatch;




        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ContactViewHolder>
{
    public static View view;
    private List<Beben> contactList;

    public CardViewAdapter(List<Beben> contactList) {
        this.contactList = contactList;
    }
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i)
    {
        Beben ci = contactList.get(i);
        contactViewHolder.vort.setText(ci.ort);
        contactViewHolder.vtime.setText(ci.time);
        contactViewHolder.vdate.setText(ci.date);
        contactViewHolder.vstarke.setText(ci.starke);
    }
    @Override
    public int getItemViewType (int position)
    {
        if(Double.parseDouble(contactList.get(position).starke) < 2.5) {
            return 1;
        }
        else if(Double.parseDouble(contactList.get(position).starke) < 3.5) {
           return 2;
        }
        else if(Double.parseDouble(contactList.get(position).starke) >= 3.5) {
            return 3;
        }
        return 0;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {

        View itemView = null;
        if(i == 1) {
            itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.card_view_green, viewGroup, false);
        }
        else if(i == 2) {
            itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.card_view_yellow, viewGroup, false);
        }
        else if(i == 3) {
            itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.card_view_red, viewGroup, false);
        }

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder
    {

        protected TextView vort;
        protected TextView vdate;
        protected TextView vtime;
        protected TextView vstarke;

        public ContactViewHolder(View v)
        {
            super(v);
            view = v;
            vort = (TextView) v.findViewById(R.id.location);
            vdate = (TextView) v.findViewById(R.id.date);
            vtime = (TextView) v.findViewById(R.id.time);
            vstarke = (TextView) v.findViewById(R.id.starke);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    System.out.println("Test");

                }

            });
        }
    }
}