package com.kdgx.service.impl;

import com.kdgx.entity.Video;
import com.kdgx.mapper.VideoMapper;
import com.kdgx.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> selectVideo() {
        return videoMapper.selectVideo();
    }

    @Override
    public Video selectVideoByvid(Video entity) {
        return videoMapper.selectVideoByvid(entity);
    }

    @Override
    public int insertVideo(Video entity) {
        return videoMapper.insertVideo(entity);
    }

    @Override
    public int deleteVideo(Video entity) {
        return videoMapper.deleteVideo(entity);
    }

    @Override
    public int updateVideo(Video entity) {
        return videoMapper.updateVideo(entity);
    }

    @Override
    public int updateVideoByvware(Video entity) {
        return videoMapper.updateVideoByvware(entity);
    }
}
