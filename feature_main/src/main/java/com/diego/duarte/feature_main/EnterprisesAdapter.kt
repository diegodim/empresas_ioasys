package com.diego.duarte.feature_main

import android.view.View
import com.diego.duarte.base_feature.core.BaseAdapter
import com.diego.duarte.base_feature.core.BaseViewHolder
import com.diego.duarte.base_feature.utils.extensions.loadUrl
import com.diego.duarte.base_presentation.model.EnterpriseBinding
import kotlinx.android.synthetic.main.item_enterprise.view.*

class EnterprisesAdapter: BaseAdapter<EnterpriseBinding, EnterprisesAdapter.EnterpriseViewHolder>() {


    override fun createViewHolderInstance(view: View) = EnterpriseViewHolder(view)

    override val layoutId: Int
        get() = R.layout.item_enterprise

    inner class EnterpriseViewHolder(private val view: View): BaseViewHolder<EnterpriseBinding>(view){
        override fun bind(item: EnterpriseBinding) {
            view.apply {
                image_photo.loadUrl(item.photo)
                text_country.text = item.country
                text_name.text = item.enterpriseName
                text_type.text = item.enterpriseType?.enterpriseTypeName

            }
        }

    }

}