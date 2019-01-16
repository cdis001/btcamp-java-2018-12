package ch13.B;

public class Score2 extends Score {

  private int music;
  private int art;  

  public int getMusic() {
    return music;
  }
  public void setMusic(int music) {
    if(music >= 0 && music <= 100) {
      this.music = music;
      this.compute();
    }
  }
  public int getArt() {
    return art;
  }
  public void setArt(int art) {
    if(art >= 0 && art <= 100) {
      this.art = art;
      this.compute();
    }
  }
  private void conpute2() {
    this.compute();
    
    this.sum += this.music + this.music;
    this.aver = this.sum /5f;
  }
}
