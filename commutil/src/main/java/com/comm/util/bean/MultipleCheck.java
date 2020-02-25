package com.comm.util.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author : John
 * @date : 2018/7/31
 */
public class MultipleCheck implements MultiItemEntity {
    public static final int TYPE_MODE_HEADER = 99; //标题头

    private final int whichHeader;
    private final int itemType;
    private MeasureData.BloodGlucoseDataListBean BloodGlucoseData;
    private MeasureData.BloodOxygenDataListBean BloodOxygenData;
    private MeasureData.BloodPhotoDataListBean BloodPhotoData;
    private MeasureData.BloodPressureDataListBean BloodPressureData;
    private FootFeelingDataListBean FootFeelingData;
    private MeasureData.TemperatureDataListBean TemperatureData;

    public int whichHeader() {
        return whichHeader;
    }

    public static int getTypeModeHeader() {
        return TYPE_MODE_HEADER;
    }

    public MeasureData.BloodGlucoseDataListBean getBloodGlucoseData() {
        return BloodGlucoseData;
    }

    public MeasureData.BloodOxygenDataListBean getBloodOxygenData() {
        return BloodOxygenData;
    }

    public MeasureData.BloodPhotoDataListBean getBloodPhotoData() {
        return BloodPhotoData;
    }

    public MeasureData.BloodPressureDataListBean getBloodPressureData() {
        return BloodPressureData;
    }

    public FootFeelingDataListBean getFootFeelingData() {
        return FootFeelingData;
    }

    public MeasureData.TemperatureDataListBean getTemperatureData() {
        return TemperatureData;
    }


    public MultipleCheck(int whichHeader, int itemType) {
        this.whichHeader = whichHeader;
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }


    public static class Builder {
        private final int whichHeader;
        private final int itemType;
        private MeasureData.BloodGlucoseDataListBean BloodGlucoseData;
        private MeasureData.BloodOxygenDataListBean BloodOxygenData;
        private MeasureData.BloodPhotoDataListBean BloodPhotoData;
        private MeasureData.BloodPressureDataListBean BloodPressureData;
        private FootFeelingDataListBean FootFeelingData;
        private MeasureData.TemperatureDataListBean TemperatureData;

        public Builder(int itemType,int whichHeader) {
            this.itemType = itemType;
            this.whichHeader = whichHeader;
        }

        public Builder addBloodGlucoseData(MeasureData.BloodGlucoseDataListBean bloodGlucoseData) {
            BloodGlucoseData = bloodGlucoseData;
            return this;
        }

        public Builder addBloodOxygenData(MeasureData.BloodOxygenDataListBean bloodOxygenData) {
            BloodOxygenData = bloodOxygenData;
            return this;
        }

        public Builder addBloodPhotoData(MeasureData.BloodPhotoDataListBean bloodPhotoData) {
            BloodPhotoData = bloodPhotoData;
            return this;
        }

        public Builder addBloodPressureData(MeasureData.BloodPressureDataListBean bloodPressureData) {
            BloodPressureData = bloodPressureData;
            return this;
        }

        public Builder addFootFeelingData(FootFeelingDataListBean footFeelingData) {
            FootFeelingData = footFeelingData;
            return this;
        }

        public Builder addTemperatureData(MeasureData.TemperatureDataListBean temperatureData) {
            TemperatureData = temperatureData;
            return this;
        }

        public MultipleCheck build() {
            return new MultipleCheck(this);
        }
    }

    public MultipleCheck(Builder builder) {
        this.itemType = builder.itemType;
        this.BloodGlucoseData = builder.BloodGlucoseData;
        this.BloodOxygenData = builder.BloodOxygenData;
        this.BloodPhotoData = builder.BloodPhotoData;
        this.BloodPressureData = builder.BloodPressureData;
        this.FootFeelingData = builder.FootFeelingData;
        this.TemperatureData = builder.TemperatureData;
        this.whichHeader = builder.whichHeader;
    }
}
