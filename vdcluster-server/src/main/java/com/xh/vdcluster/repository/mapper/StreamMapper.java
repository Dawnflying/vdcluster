package com.xh.vdcluster.repository.mapper;


import com.xh.vdcluster.repository.model.Stream;

/**
 * Created by macbookpro on 17/7/23.
 */
public interface StreamMapper {
    Stream getStreamById(int id);

    void deleteStream(int id);

    void insertStream(Stream stream);

    void updateStream(Stream stream);

}
