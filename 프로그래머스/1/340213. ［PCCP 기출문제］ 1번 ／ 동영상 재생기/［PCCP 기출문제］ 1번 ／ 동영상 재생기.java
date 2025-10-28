class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int totalH = Integer.parseInt(video_len.split(":")[0]);
        int totalM = Integer.parseInt(video_len.split(":")[1]);
        int Phour = Integer.parseInt(pos.split(":")[0]);
        int Pmin = Integer.parseInt(pos.split(":")[1]);
        int opSHour = Integer.parseInt(op_start.split(":")[0]);
        int opSMin = Integer.parseInt(op_start.split(":")[1]);
        int opEHour = Integer.parseInt(op_end.split(":")[0]);
        int opEMin = Integer.parseInt(op_end.split(":")[1]);

        if ((Phour > opSHour || (Phour == opSHour && Pmin >= opSMin)) &&
            (Phour < opEHour || (Phour == opEHour && Pmin <= opEMin))) {
            Phour = opEHour;
            Pmin = opEMin;
        }

        for (String n : commands) {
            switch (n) {
                case "prev":
                    Pmin -= 10;
                    if (Pmin < 0) {
                        Pmin += 60;
                        Phour -= 1;
                        if (Phour < 0) {
                            Phour = 0;
                            Pmin = 0;
                        }
                    }
                    break;

                case "next":
                    Pmin += 10;
                    if (Pmin >= 60) {
                        Pmin -= 60;
                        Phour += 1;
                    }

                    if (Phour > totalH || (Phour == totalH && Pmin > totalM)) {
                        Phour = totalH;
                        Pmin = totalM;
                    }
                    break;
            }

            if ((Phour > opSHour || (Phour == opSHour && Pmin >= opSMin)) &&
                (Phour < opEHour || (Phour == opEHour && Pmin <= opEMin))) {
                Phour = opEHour;
                Pmin = opEMin;
            }
        }

        return String.format("%02d:%02d", Phour, Pmin);
    }
}
