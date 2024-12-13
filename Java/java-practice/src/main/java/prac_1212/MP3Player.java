package prac_1212;

public class MP3Player {
    private String modelName;
    private int volume;
    private boolean isPowerOn;

    public MP3Player(String modelName) {
        this.modelName = modelName;
    }

    // TV가 켜져있을 때 리모콘 파워 버튼을 누르면 꺼지고, 꺼져있을 때 버튼을 누르면 켜지는 개념
    public boolean pushPowerButton() {
        if(this.isPowerOn) {
            return this.turnOff();
        } else {
            return this.turnOn();
        }
    }

    public boolean turnOn() {
        this.isPowerOn = true;
        this.volume = 40;

        return this.isPowerOn;
    }

    public boolean turnOff() {
        this.isPowerOn = false;
        this.volume = 0;

        return this.isPowerOn;
    }

    public int volumeUp() {
        // if(!isPowerOn)
        if(isPowerOn == false) {
            return 0;
        }

        this.volume += 20;

        if(this.volume > 100) {
            this.volume = 100;
        }

        return this.volume;
    }

    public int volumeDown() {
        // if(!isPowerOn)
        if(isPowerOn == false) {
            return 0;
        }

        this.volume -= 20;

        if(this.volume < 0) {
            this.volume = 0;
        }

        return this.volume;
    }

    public void MP3Info() {
        System.out.println("모델명은 " + this.modelName + "이고, 볼륨 상태는 " + this.volume + "이고, 전원은 " + this.isPowerOn + "상태입니다.");
    }
}
