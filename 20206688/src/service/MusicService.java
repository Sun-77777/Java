package service;

import dao.MusicDao;
import entity.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicService {

    //查找歌曲
    public List<Music> findAllMusic() {
        List<Music> musicList = new ArrayList<>();
        MusicDao musicDao = new MusicDao();
        musicList = musicDao.findAllMusic();
        return musicList;
    }

    //模糊查找歌曲
    public List<Music> ifMusic(String str) {
        List<Music> musicList = new ArrayList<>();
        MusicDao musicDao = new MusicDao();
        musicList = musicDao.ifMusic(str);
        return musicList;
    }

    //添加歌曲
    public int insertMusic(String title,String singer,String time,String url,int userid) {
        MusicDao musicDao = new MusicDao();
        int ret = musicDao.insertMusic(title, singer, time, url, userid);
        return ret;
    }

    //根据id查找音乐
    public Music findMusicById(int id) {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        music = musicDao.findMusicById(id);
        return music;
    }

    //删除歌曲根据id
    public int deleteMusicById(int id) {
        MusicDao musicDao = new MusicDao();
        int ret = musicDao.deleteMusicById(id);
        return ret;
    }

    public boolean insertLoveMusic(int userid,int musicid) {
        MusicDao musicDao = new MusicDao();
        if (!musicDao.findMusicByMusicId(userid, musicid)) {
            if (musicDao.insertLoveMusic(userid, musicid)) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
