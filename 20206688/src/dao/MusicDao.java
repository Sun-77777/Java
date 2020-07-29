package dao;

import entity.Music;
import util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    /**
     * 查询全部歌单
     * @return
     */
    public List<Music> findAllMusic() {
        List<Music> listmusic = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from music";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                listmusic.add(music);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return listmusic;
    }

    /**
     * 根据id查找音乐
     * @param id
     * @return
     */
    public Music findMusicById(int id) {
        Music music = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from music where id = ?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            rs = ps.executeQuery();
            if (rs.next()) {
                music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return music;
    }

    /**
     * 根据关键字查询音乐（模糊查询）
     * @param str
     * @return
     */
    public List<Music> ifMusic(String str) {
        List<Music> musicList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from music where title like '%" + str + "'%";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return musicList;
    }

    /**
     * 上传音乐
     * @param music
     * @return
     */
    public int uploadMusic(Music music) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into music vlaues (null,?,?,?,?,?)";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,music.getTitle());
            ps.setString(2,music.getSinger());
            ps.setDate(3, (Date) music.getTime());
            ps.setString(4,music.getUrl());
            ps.setInt(5,music.getUserid());
            int ret = ps.executeUpdate();
            if (ret == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return 0;
    }

    /**
     * 删除歌曲
     * @param id
     * @return
     */
    public int deleteMusicById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "delete from music where id = ?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int ret = ps.executeUpdate();
            if (ret == 1) {
                if (isLoveMusic(id)) {
                    return deleteMusicInLove(id);
                }
                return 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return 0;
    }
    //删除lovemusic 中的歌曲
    public int deleteMusicInLove(int id) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String sql = "delete from lovemusic where music_id = ?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int ret = ps.executeUpdate();
            if (ret == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,null);
        }
        return 0;
    }
    //判断歌曲是否在lovemusic中
    public boolean isLoveMusic(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from lovemusic where music_id = ?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return false;
    }

    //在添加喜欢的音乐之前，要先判断是否已经被加过
    public boolean findMusicByMusicId(int userid,int musicid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from lovemusic where user_id = ? and music_id = ?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            ps.setInt(2,musicid);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return false;
    }

    /**
     * 添加音乐到喜欢列表中
     * @param userid
     * @param musicid
     * @return
     */
    public boolean insertLoveMusic(int userid,int musicid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "insert into lovemusic(user_id,music_id) values (?,?)";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            ps.setInt(2,musicid);
            int ret = ps.executeUpdate();
            if (ret == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return false;
    }

    /**
     * 移除喜欢的音乐
     * @param userid
     * @param musicid
     * @return
     */
    public int removeLoveMusic(int userid,int musicid) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String sql = "delete form lovemusic where user_id = ? and music_id = ?";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            ps.setInt(2,musicid);
            int ret = ps.executeUpdate();
            if (ret == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,null);
        }
        return 0;
    }

    /**
     * 查询用户喜欢的全部歌单
     * @return
     */
    public List<Music> findLoveMusic(int userid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Music> musicList = new ArrayList<>();

        try {
            String sql = "select * from music where id = (select music_id from lovemusic where user_id = ?)";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ps.setInt(1,userid);
            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return musicList;
    }

    public List<Music> ifMusicLove(String str,int userid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Music> musiclist = new ArrayList<>();

        try {
            String sql = "select * from music where id = (select music_id from lovemusic where user_id = ?) and title like '%" + str + "%'";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musiclist.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,ps,rs);
        }
        return musiclist;
        
    }

    public static void main(String[] args) {
        /*List<Music> musicList = findAllMusic();
        System.out.println(musicList);*/
    }
}
