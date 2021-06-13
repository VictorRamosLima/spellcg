package br.com.spellcg.domain;

import org.hibernate.type.EnumType;

public class ProductEnumType extends EnumType {

}

/*: EnumType<Product>() {
        override fun nullSafeSet(
        st: PreparedStatement?,
        value: Any?,
        index: Int,
        session: SharedSessionContractImplementor?
        ) {
        st?.setObject(index, value, Types.OTHER)
        }
        }

 */