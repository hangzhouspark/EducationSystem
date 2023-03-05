package com.kdgx.mapper;


import com.kdgx.entity.Video;

import java.util.List;

public interface VideoMapper {
    /**
     * 查询所有视频信息
     *
     * @return
     */
    public List<Video> selectVideo();

    /**
     * 根据ID查询视频信息
     *
     * @return
     */
    public Video selectVideoByvid(Video entity);

    /**
     * 添加视频信息
     *
     * @return
     */
    public int insertVideo(Video entity);

    /**
     * 删除视频信息
     *
     * @return
     */
    public int deleteVideo(Video entity);

    /**
     * 修改除视频外的视频信息
     *
     * @return
     */
    public int updateVideo(Video entity);

    /**
     * 修改视频
     *
     * @return
     */
    public int updateVideoByvware(Video entity);
}
