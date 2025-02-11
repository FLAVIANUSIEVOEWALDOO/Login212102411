package com.ievo.login;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaViewHolder> {
    private List<MahasiswaModel> _mahasiswaModelList;

    public MahasiswaAdapter(List<MahasiswaModel> mahasiswaModelList){
        this._mahasiswaModelList = mahasiswaModelList;
    }
    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_mahasiswa, parent, false);
        return new MahasiswaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        MahasiswaModel nm = _mahasiswaModelList.get(position);

        holder._jkImageView.setImageResource(R.drawable.boy);

        if(nm.getJenisKelamin().toLowerCase().equals("perempuan")){
            holder._jkImageView.setImageResource(R.drawable.girl);
        }

        holder._nimTextView.setText(nm.getNIM());
        holder._namaTextView.setText(nm.getNama());
        holder._jkTextView.setText(nm.getJenisKelamin());

        String jp = nm.getJP();
        jp = jp.substring(0,2);
        holder._jpTextView.setText(jp);
    }

    @Override
    public int getItemCount() {
        int count = 0;

        if (_mahasiswaModelList != null)
        {
            count = _mahasiswaModelList.size();
        }
        return count;
    }
}
