        // 1
        // List mNamesList
        mNamesList.removeAll(mNamesList);


        // 2
        if (editCar != null || editCar.getVehicleId() < 0) {
            itemMenuDelete.setVisible(true);
        }


        // 3
        String imagePath = oldImages.get(i).toString();
        imagePath.replace("\\/", "/");
        if (mOutterListFirst.contains(imagePath)) {
            mOutterListFirst.remove(imagePath);
        }


        // 4
        if (spinnerStat != null) {
            spinnerStat.setBackgroundResource(R.drawable.bg_spinner);
        } else {
            spinnerStat.setBackgroundResource(R.drawable.bg_spinner_error);
        }


        // 5
        for (BluetoothDevice device : pairedDevices) {
            if (device.getAddress().equalsIgnoreCase(remoteDevice)) {
                startCommandsLoading();
            }
            break;
        }


        // 6
        public void setFacilitateCode (String code){
            code = code;
        }


        // 7
        public int getTongue () {
            return tongue = tongue;
        }

        public int getTires () {
            return tires = tires;
        }

        public int getTank_type () {
            return tank_type = tank_type;
        }

        public int getSuspension () {
            return suspension = suspension;
        }


        // 8
        if (itemIdForTitle.equalsIgnoreCase("Left Rocker Panel")) {
            itemIdForTitle = "Right Rocker Panel";
        } else if (itemIdForTitle.equalsIgnoreCase("Left Rocker Panel")) {
            itemIdForTitle = "Left Front Rocker Panel";
        }


        // 9
        public static String getWebStyleName (String name) {
            switch (name) {
                case "left_bed_side":
                    name = "Left Bed Side";
                    break;

                case "Left Bed Side":
                    name = "Left Bed Side";
                    break;

                case "left_bed_side":
                    name = "Left Bed Side";
                    break;

                default:
                    name = name.replaceAll("_", " ");
                    name = StringUtils.capitalizeFully(name);
            }
        }
