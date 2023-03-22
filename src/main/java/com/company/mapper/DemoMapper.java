package com.company.mapper;

import com.company.dto.DemoDTO;
import com.company.dto.MappedDemoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface DemoMapper {

    @Mapping(target = "date2", source = "date1", qualifiedByName = "dateToString")
    @Mapping(target = "str2", source = "str1")
    MappedDemoDTO map(final DemoDTO demoDTO);

    @Named("dateToString")
    default String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
