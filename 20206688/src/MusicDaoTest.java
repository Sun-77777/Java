import dao.MusicDao;
import entity.Music;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MusicDaoTest {

    @Test
    public void findAllMusic() {
        MusicDao musicDao = new MusicDao();
        List<Music> listmusic = new ArrayList<>();
        listmusic = musicDao.findAllMusic();
        System.out.println(listmusic.size());
    }

    @Test
    public void findMusicById() {
        MusicDao musicDao = new MusicDao();
        Music music = new Music();
        music = musicDao.findMusicById(2);
        System.out.println(music.getTitle());

    }

    @Test
    public void ifMusic() {
        List<Music> musicList = new ArrayList<>();
        MusicDao musicDao = new MusicDao();
        musicList = musicDao.ifMusic("了");
        System.out.println(musicList.size());
    }



    @Test
    public void deleteMusicById() {
    }

    @Test
    public void deleteMusicInLove() {
    }

    @Test
    public void isLoveMusic() {
    }

    @Test
    public void findMusicByMusicId() {
    }

    @Test
    public void insertLoveMusic() {
    }

    @Test
    public void removeLoveMusic() {
    }

    @Test
    public void findLoveMusic() {
    }

    @Test
    public void ifMusicLove() {
    }
}