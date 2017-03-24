package com.denghb.sqlite.example.criteria;

import com.denghb.dbhelper.paging.Paging;

/**
 * Created by ppd on 2017/3/24.
 */
public class UserCriteria extends Paging {
    @Override
    public String[] getSorts() {
        return new String[]{"id"};
    }
}
