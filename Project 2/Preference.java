public class Preference {

	int quietTime;
	int music;
	int reading;
	int chatting;
	public int getChatting() {
		return chatting;
	}
	public int getQuietTime() {
		return quietTime;
	}

	public int getReading() {
		return reading;
	}

	public int getMusic() {
		return music;
	}

	public Preference(int quietTime, int music, int reading, int chatting) {
		if (quietTime >= 0 && quietTime <= 10)
			this.quietTime = quietTime;

		if (music >= 0 && music <= 10)
			this.music = music;

		if (reading >= 0 && reading <= 10)
			this.reading = reading;

		if (chatting >= 0 && chatting <= 10)
			this.chatting = chatting;
	}



	public int compare(Preference pref) {
		return (Math.abs(reading - pref.reading)+Math.abs(music - pref.music)+Math.abs(chatting - pref.chatting)+Math.abs(quietTime - pref.quietTime));
	}

}