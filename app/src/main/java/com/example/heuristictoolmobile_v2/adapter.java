package com.example.heuristictoolmobile_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    private List<lista_evPublicas> evPublicas;
    private LayoutInflater inflater;
    private Context context;
    //final adaptador.OnItemClickListener listener;

   /* public interface OnItemClickListener{
        void onItemClick(listaBecas item);
    } */

    public adapter(List<lista_evPublicas> lista, Context context/*, adaptador.OnItemClickListener listener*/) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.evPublicas = lista;
        //this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return evPublicas.size();
    }

    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.formato_card, null);
        return new adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final adapter.ViewHolder holder, final int position) {
        holder.bindData(evPublicas.get(position));
    }

    public void setItems(List<lista_evPublicas> items){
        evPublicas = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView campo1, campo2, campo3, campo4, campo5, campo6, campo7, campo8;

        ViewHolder(View itemView){
            super(itemView);

            campo1 = itemView.findViewById(R.id.campoId);
            campo2 = itemView.findViewById(R.id.campoEmpresa);
            campo3 = itemView.findViewById(R.id.campoTipoImplementacion);
            campo4 = itemView.findViewById(R.id.campoTipoAplicacion);
            campo5 = itemView.findViewById(R.id.campoTipoEvaluacion);
            campo6 = itemView.findViewById(R.id.campoProposito);
            campo7 = itemView.findViewById(R.id.campoUsuarioCreador);
            campo8 = itemView.findViewById(R.id.campoAño);

        }

        void bindData(final lista_evPublicas item){

            campo1.setText(item.getId());
            campo2.setText(item.getEmpresa());
            campo3.setText(item.getTipoImplementacion());
            campo4.setText(item.getTipoAplicacion());
            campo5.setText(item.getTipoEvaluacion());
            campo6.setText(item.getProposito());
            campo7.setText(item.getUsuarioCreador());
            campo8.setText(item.getAño());

            /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            }); */
        }

    }
}
