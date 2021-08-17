package com.diego.duarte.feature_main.adapter

import android.view.View
import com.diego.duarte.base_feature.core.BaseAdapter
import com.diego.duarte.base_feature.core.BaseViewHolder
import com.diego.duarte.base_feature.utils.extensions.loadUrl
import com.diego.duarte.base_presentation.model.EnterpriseBinding
import com.diego.duarte.feature_main.R
import kotlinx.android.synthetic.main.item_enterprise.view.*

class EnterprisesAdapter(val clickListener: (enterprise: EnterpriseBinding) -> Unit):
    BaseAdapter<EnterpriseBinding, EnterprisesAdapter.EnterpriseViewHolder>() {


    override fun createViewHolderInstance(view: View) = EnterpriseViewHolder(view)

    override val layoutId: Int
        get() = R.layout.item_enterprise

    inner class EnterpriseViewHolder(private val view: View): BaseViewHolder<EnterpriseBinding>(view){
        override fun bind(enterprise: EnterpriseBinding) {
            view.apply {
                image_photo.loadUrl(view.context.getString(R.string.url_image) + enterprise.photo)
                text_country.text = enterprise.country
                text_name.text = enterprise.enterpriseName
                text_type.text = enterprise.enterpriseType.enterpriseTypeName
                setOnClickListener { clickListener(enterprise) }
            }
        }

    }

}