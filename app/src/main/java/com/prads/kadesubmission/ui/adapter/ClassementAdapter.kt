package com.prads.kadesubmission.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.Classement
import com.prads.kadesubmission.ui.layout.ClassementItemUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class ClassementAdapter(private val listener: (Classement) -> Unit) :
    RecyclerView.Adapter<ClassementAdapter.ClassementViewHolder>() {

    private val classements = mutableListOf<Classement>()

    fun addData(classements: List<Classement>) {
        classements.let {
            this.classements.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassementViewHolder {
        return ClassementViewHolder(
            ClassementItemUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun getItemCount(): Int = classements.size
    override fun onBindViewHolder(holder: ClassementViewHolder, position: Int) {
        holder.bindItem(classements[position], listener)
    }

    class ClassementViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

//        private val teamLogo: ImageView = containerView.find(R.id.item_team_logo)

        fun bindItem(item: Classement, listener: (Classement) -> Unit) {

//            Glide.with(itemView.context)
//                .load(item.strClassementLogo)
//                .into(teamLogo)

            containerView.find<TextView>(R.id.tv_classement_item_team).text = item.name
            containerView.find<TextView>(R.id.tv_classement_item_win).text = item.win.toString()
            containerView.find<TextView>(R.id.tv_classement_item_loss).text = item.loss.toString()
            containerView.find<TextView>(R.id.tv_classement_item_draw).text = item.draw.toString()
            containerView.find<TextView>(R.id.tv_classement_item_total).text = item.total.toString()


        }


    }


}
