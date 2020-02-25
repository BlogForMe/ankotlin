package com.comm.util.bean;

import java.util.List;

/**
 * @author : John
 * @date : 2018/8/20
 */
public class PictureUp {

    private List<ModelListBean> model_list;

    public List<ModelListBean> getModel_list() {
        return model_list;
    }

    public void setModel_list(List<ModelListBean> model_list) {
        this.model_list = model_list;
    }

    public static class ModelListBean {
        /**
         * file_group_id : ab6bfb50b4e24c39ab9ae524c266e925
         * file_id : ee78f4ad4e57434da434d123ac3e4e79
         * file_name : foot_02920486039126807426.png
         * file_path : 20180820/foot_02920486039126807426.png
         * file_size : 713174
         * new_file_name : foot_02920486039126807426.png
         */

        private String file_group_id;
        private String file_id;
        private String file_name;
        private String file_path;
        private int file_size;
        private String new_file_name;

        public String getFile_group_id() {
            return file_group_id;
        }

        public void setFile_group_id(String file_group_id) {
            this.file_group_id = file_group_id;
        }

        public String getFile_id() {
            return file_id;
        }

        public void setFile_id(String file_id) {
            this.file_id = file_id;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public int getFile_size() {
            return file_size;
        }

        public void setFile_size(int file_size) {
            this.file_size = file_size;
        }

        public String getNew_file_name() {
            return new_file_name;
        }

        public void setNew_file_name(String new_file_name) {
            this.new_file_name = new_file_name;
        }

        @Override
        public String toString() {
            return "ModelListBean{" +
                    "file_group_id='" + file_group_id + '\'' +
                    ", file_id='" + file_id + '\'' +
                    ", file_name='" + file_name + '\'' +
                    ", file_path='" + file_path + '\'' +
                    ", file_size=" + file_size +
                    ", new_file_name='" + new_file_name + '\'' +
                    '}';
        }
    }


}
