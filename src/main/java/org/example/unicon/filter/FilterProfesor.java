package org.example.unicon.filter;

import org.example.unicon.util.Global;
import org.openxava.filters.FilterException;
import org.openxava.filters.IFilter;

public class FilterProfesor implements IFilter {

    @Override
    public Object filter(Object o) throws FilterException {
        return new Object[] {Global.userName};

    }
}
