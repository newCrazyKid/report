package com.ai.rti.report.entity;

import java.math.BigDecimal;

public class Target {
    private BigDecimal obj_user_cnt;
    private BigDecimal day_touch_user_cnt;
    private BigDecimal month_touch_user_cnt;
    private BigDecimal total_touch_user_cnt;
    private BigDecimal day_success_user_cnt;
    private BigDecimal month_success_user_cnt;
    private BigDecimal total_success_user_cnt;
    private BigDecimal day_cover_ratio;
    private BigDecimal month_cover_ratio;
    private BigDecimal total_cover_ratio;
    private BigDecimal day_success_ratio;
    private BigDecimal month_success_ratio;
    private BigDecimal total_success_ratio;
    private String data_time;
//    private BigDecimal screen_cnt;

    public BigDecimal getObj_user_cnt() {
        return obj_user_cnt;
    }

    public void setObj_user_cnt(BigDecimal obj_user_cnt) {
        this.obj_user_cnt = obj_user_cnt;
    }

    public BigDecimal getDay_touch_user_cnt() {
        return day_touch_user_cnt;
    }

    public void setDay_touch_user_cnt(BigDecimal day_touch_user_cnt) {
        this.day_touch_user_cnt = day_touch_user_cnt;
    }

    public BigDecimal getMonth_touch_user_cnt() {
        return month_touch_user_cnt;
    }

    public void setMonth_touch_user_cnt(BigDecimal month_touch_user_cnt) {
        this.month_touch_user_cnt = month_touch_user_cnt;
    }

    public BigDecimal getTotal_touch_user_cnt() {
        return total_touch_user_cnt;
    }

    public void setTotal_touch_user_cnt(BigDecimal total_touch_user_cnt) {
        this.total_touch_user_cnt = total_touch_user_cnt;
    }

    public BigDecimal getDay_success_user_cnt() {
        return day_success_user_cnt;
    }

    public void setDay_success_user_cnt(BigDecimal day_success_user_cnt) {
        this.day_success_user_cnt = day_success_user_cnt;
    }

    public BigDecimal getMonth_success_user_cnt() {
        return month_success_user_cnt;
    }

    public void setMonth_success_user_cnt(BigDecimal month_success_user_cnt) {
        this.month_success_user_cnt = month_success_user_cnt;
    }

    public BigDecimal getTotal_success_user_cnt() {
        return total_success_user_cnt;
    }

    public void setTotal_success_user_cnt(BigDecimal total_success_user_cnt) {
        this.total_success_user_cnt = total_success_user_cnt;
    }

    public BigDecimal getDay_cover_ratio() {
        return day_cover_ratio;
    }

    public void setDay_cover_ratio(BigDecimal day_cover_ratio) {
        this.day_cover_ratio = day_cover_ratio;
    }

    public BigDecimal getMonth_cover_ratio() {
        return month_cover_ratio;
    }

    public void setMonth_cover_ratio(BigDecimal month_cover_ratio) {
        this.month_cover_ratio = month_cover_ratio;
    }

    public BigDecimal getTotal_cover_ratio() {
        return total_cover_ratio;
    }

    public void setTotal_cover_ratio(BigDecimal total_cover_ratio) {
        this.total_cover_ratio = total_cover_ratio;
    }

    public BigDecimal getDay_success_ratio() {
        return day_success_ratio;
    }

    public void setDay_success_ratio(BigDecimal day_success_ratio) {
        this.day_success_ratio = day_success_ratio;
    }

    public BigDecimal getMonth_success_ratio() {
        return month_success_ratio;
    }

    public void setMonth_success_ratio(BigDecimal month_success_ratio) {
        this.month_success_ratio = month_success_ratio;
    }

    public BigDecimal getTotal_success_ratio() {
        return total_success_ratio;
    }

    public void setTotal_success_ratio(BigDecimal total_success_ratio) {
        this.total_success_ratio = total_success_ratio;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    @Override
    public String toString() {
        return "Target{" +
                "obj_user_cnt=" + obj_user_cnt +
                ", day_touch_user_cnt=" + day_touch_user_cnt +
                ", month_touch_user_cnt=" + month_touch_user_cnt +
                ", total_touch_user_cnt=" + total_touch_user_cnt +
                ", day_success_user_cnt=" + day_success_user_cnt +
                ", month_success_user_cnt=" + month_success_user_cnt +
                ", total_success_user_cnt=" + total_success_user_cnt +
                ", day_cover_ratio=" + day_cover_ratio +
                ", month_cover_ratio=" + month_cover_ratio +
                ", total_cover_ratio=" + total_cover_ratio +
                ", day_success_ratio=" + day_success_ratio +
                ", month_success_ratio=" + month_success_ratio +
                ", total_success_ratio=" + total_success_ratio +
                ", data_time='" + data_time + '\'' +
                '}';
    }
}
