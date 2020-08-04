$(function() {

        var $fullText = $('.admin-fullText');
        $('#admin-fullscreen').on('click', function() {
            $.AMUI.fullscreen.toggle();
        });

        $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
            $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
        });


        var dataType = $('body').attr('data-type');
        for (key in pageData) {
            if (key == dataType) {
                pageData[key]();
            }
        }

        $('.tpl-switch').find('.tpl-switch-btn-view').on('click', function() {
            $(this).prev('.tpl-switch-btn').prop("checked", function() {
                    if ($(this).is(':checked')) {
                        return false
                    } else {
                        return true
                    }
                })
                // console.log('123123123')

        })
    })
    // ==========================
    // 侧边导航下拉列表
    // ==========================

$('.tpl-left-nav-link-list').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico').toggleClass('tpl-left-nav-more-ico-rotate');
})
$('.tpl-left-nav-link-list1').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu1').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico1').toggleClass('tpl-left-nav-more-ico-rotate1');
})
$('.tpl-left-nav-link-list2').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu2').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico2').toggleClass('tpl-left-nav-more-ico-rotate2');
})
$('.tpl-left-nav-link-list3').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu3').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico3').toggleClass('tpl-left-nav-more-ico-rotate3');
})
$('.tpl-left-nav-link-list4').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu4').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico4').toggleClass('tpl-left-nav-more-ico-rotate4');
})
$('.tpl-left-nav-link-list5').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu5').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico5').toggleClass('tpl-left-nav-more-ico-rotate5');
})
$('.tpl-left-nav-link-list6').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu6').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico6').toggleClass('tpl-left-nav-more-ico-rotate6');
})
$('.tpl-left-nav-link-list7').on('click', function() {
    $(this).siblings('.tpl-left-nav-sub-menu7').slideToggle(80)
        .end()
        .find('.tpl-left-nav-more-ico7').toggleClass('tpl-left-nav-more-ico-rotate7');
})
$('.tpl-left-nav-link-list8').on('click', function() {
        $(this).siblings('.tpl-left-nav-sub-menu8').slideToggle(80)
            .end()
            .find('.tpl-left-nav-more-ico8').toggleClass('tpl-left-nav-more-ico-rotate8');
    })
    // ==========================
    // 头部导航隐藏菜单
    // ==========================

$('.tpl-header-nav-hover-ico').on('click', function() {
    $('.tpl-left-nav').toggle();
    $('.tpl-content-wrapper').toggleClass('tpl-content-wrapper-hover');
})


// 页面数据
var pageData = {
    // ===============================================
    // 首页
    // ===============================================
    'index': function indexData() {


        // var myScroll = new IScroll('#wrapper', {
        //     scrollbars: true,
        //     mouseWheel: true,
        //     interactiveScrollbars: true,
        //     shrinkScrollbars: 'scale',
        //     preventDefault: false,
        //     fadeScrollbars: true
        // });
        //
        // var myScrollA = new IScroll('#wrapperA', {
        //     scrollbars: true,
        //     mouseWheel: true,
        //     interactiveScrollbars: true,
        //     shrinkScrollbars: 'scale',
        //     preventDefault: false,
        //     fadeScrollbars: true
        // });
        //
        // var myScrollB = new IScroll('#wrapperB', {
        //     scrollbars: true,
        //     mouseWheel: true,
        //     interactiveScrollbars: true,
        //     shrinkScrollbars: 'scale',
        //     preventDefault: false,
        //     fadeScrollbars: true
        // });



        // document.addEventListener('touchmove', function(e) { e.preventDefault(); }, false);

        // ==========================
        // 百度图表A http://echarts.baidu.com/
        // ==========================

        var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
        option = {

            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: ['温度', '湿度', '光照度']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                boundaryGap: true,
                data: ['90m前', '75m前', '60m前', '45m前', '30m前', '15m前', '当前时间']
            }],

            yAxis: [{
                type: 'value'
            }],
            series: [{
                    name: '温度',
                    type: 'line',
                    // stack: '总量',
                    areaStyle: { normal: {} },
                    data: [120, 132, 101, 134, 90, 230, 210],
                    itemStyle: {
                        normal: {
                            color: '#a9aeea'
                        },
                        emphasis: {

                        }
                    }
                },
                {
                    name: '湿度',
                    type: 'line',
                    // stack: '总量',
                    areaStyle: { normal: {} },
                    data: [220, 182, 191, 234, 290, 330, 310],
                    itemStyle: {
                        normal: {
                            color: '#e7505a'
                        }
                    }
                },
                {
                    name: '光照度',
                    type: 'line',
                    // stack: '总量',
                    areaStyle: { normal: {} },
                    data: [150, 232, 201, 154, 190, 330, 410],
                    itemStyle: {
                        normal: {
                            color: '#32c5d2'
                        }
                    }
                }
            ]
        };
        echartsA.setOption(option);
    },
    // ===============================================
    // 图表页
    // ===============================================
    'chart': function chartData() {
        // ==========================
        // 百度图表A http://echarts.baidu.com/
        // ==========================

        var echartsC = echarts.init(document.getElementById('tpl-echarts-C'));


        optionC = {
            tooltip: {
                trigger: 'axis'
            },
            toolbox: {
                top: '0',
                feature: {
                    mark: true,
                    dataView: { show: true, readOnly: false },
                    magicType: { show: true, type: ['line', 'bar'] },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            title: {
                // text: '摸鱼时间到了'
            },
            legend: {
                data: ['消耗水量', '疫苗量', '消耗饲料']
            },
            xAxis: [{
                type: 'category',
                data: ['7月21日', '7月22日', '7月23日', '7月24日', '7月25日', '7月26日', '7月27日', '7月28日', '7月29日', '7月30日', '7月31日', '8月1日']
            }],
            yAxis: [{
                    type: 'value',
                    name: '体积',
                    min: 0,
                    max: 30,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value} m³'
                    }
                },
                {
                    type: 'value',
                    name: '消耗饲料量',
                    min: 0,
                    max: 30,
                    interval: 5,
                    axisLabel: {
                        formatter: '{value} kg'
                    }
                }
            ],
            series: [{
                    name: '消耗水量',
                    type: 'bar',
                    data: [22.0, 24.9, 27.0, 23.2, 25.6, 26.7, 25.6, 22.2, 22.6, 20.0, 26.4, 23.3]
                },
                {
                    name: '疫苗量',
                    type: 'bar',
                    data: [2.0, 2.4, 1.9, 2.0, 1.6, 2.4, 1.9, 2.0, 1.8, 2.1, 2.0, 2.3]
                },
                {
                    name: '消耗饲料',
                    type: 'line',
                    yAxisIndex: 1,
                    data: [21, 19, 20, 18, 21, 25, 20, 27, 19, 21, 28, 25]
                }
            ]
        };
        echartsC.setOption(optionC);








        function randomData() {
            now = new Date(+now + oneDay);
            value = value + Math.random() * 21 - 10;
            return {
                name: now.toString(),
                value: [
                    [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
                    Math.round(value)
                ]
            }
        }

        var data = [];
        var now = +new Date(1997, 9, 3);
        var oneDay = 24 * 3600 * 1000;
        var value = (Math.random() * 15 + 15);
        for (var i = 0; i < 1000; i++) {
            data.push(randomData());
        }


        var echartsB = echarts.init(document.getElementById('tpl-echarts-B'));
        optionB = {
            title: {
                text: 'x猪舍温度实时数据'
            },
            tooltip: {
                trigger: 'axis',
                formatter: function(params) {
                    params = params[0];
                    var date = new Date(params.name);
                    return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1] + "℃";
                },
                axisPointer: {
                    animation: false
                }
            },
            xAxis: {
                type: 'time',
                splitLine: {
                    show: false
                }
            },
            yAxis: {
                type: 'value',
                boundaryGap: [0, '100%'],
                splitLine: {
                    show: false
                }
            },
            series: [{
                name: '模拟数据',
                type: 'line',
                showSymbol: false,
                hoverAnimation: false,
                data: data
            }]
        };

        setInterval(function() {

            for (var i = 0; i < 5; i++) {
                data.shift();
                data.push(randomData());
            }

            echartsB.setOption(optionB, {
                series: [{
                    data: data
                }]
            });
        }, 1000);


        echartsB.setOption(optionB);




        var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
        option = {
            title: {
                text: 'xxx猪舍环境信息',
                subtext: '日期：2019-7-31'
            },
            tooltip: {
                trigger: 'axis',
                // formatter: function(params) {
                //     params = params[0];
                //     var date = new Date(params.name);
                //     return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
                // },
                axisPointer: {
                    animation: false
                },

                formatter: '{b}<br/>{a0}:{c0}℃,<br/>{a1}:{c1}%RH,<br/>{a2}:{c2}Lux,<br/>{a3}:{c3}ppm,<br/>{a4}:{c4}ppm<br/>'

            },
            legend: {
                data: ['温度', '湿度', '光照度', '二氧化碳浓度', '硫化氢浓度']
            },
            toolbox: {
                show: true,
                feature: {
                    mark: { show: true },
                    dataView: { show: true, readOnly: false },
                    magicType: { show: true, type: ['line', 'bar', 'stack', 'tiled'] },
                    restore: { show: true },
                    saveAsImage: { show: true }
                }
            },
            calculable: true,
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                boundaryGap: true,
                data: ['0:00', '2:00', '4:00', '6:00', '8:00', '10:00', '12:00', '14:00', '16:00', '18:00', '20:00', '22:00']
            }],

            yAxis: [{
                type: 'value',
                position: 'left',
                splitLine: { show: true },
                axisLine: {
                    show: false,

                    /*  lineStyle: {
                          color: '#E7E7E7'
                      }*/
                },
                axisLabel: {
                    show: true,
                    showMinLabel: true,
                    showMaxLabel: true,
                    formatter: '{value}'
                },
            }],
            series: [{
                    name: '温度',
                    type: 'line',
                    //stack: '总量',
                    // areaStyle: { normal: {} },
                    data: [{ value: 31.5, name: '非温度', unit: '℃' }, { value: 32, name: '非温度', unit: '℃' }, { value: 31, name: '非温度', unit: '℃' }, { value: 30, name: '非温度', unit: '℃' }, { value: 30.5, name: '非温度', unit: '℃' }, { value: 31, name: '非温度', unit: '℃' }, { value: 29.5, name: '非温度', unit: '℃' }, 31, 32, 33, 34, 29],
                    itemStyle: {
                        normal: {
                            color: '#19ae12'
                        },
                        // emphasis: {

                        // }
                    },
                    markPoint: {
                        data: [
                            { type: 'max', name: '最大值' },
                            { type: 'min', name: '最小值' }
                        ]
                    },
                    markLine: {
                        data: [
                            // { type: 'average', name: '平均值' }
                        ]
                    }

                },
                {
                    name: '湿度',
                    type: 'line',
                    //stack: '总量',
                    // areaStyle: { normal: {} },
                    data: [50, 55, 50, 45, 55, 50, 60, 51, 54, 56, 58, 51],
                    itemStyle: {
                        normal: {
                            color: '#e7505a'
                        }
                    },
                    markPoint: {
                        data: [
                            { type: 'max', name: '最大值' },
                            { type: 'min', name: '最小值' }
                        ]
                    },
                    markLine: {
                        data: [
                            // { type: 'average', name: '平均值' }
                        ]
                    }
                },
                {
                    name: '光照度',

                    type: 'line',
                    //stack: '总量',
                    // areaStyle: { normal: {} },
                    data: [40, 50, 45, 50, 45, 60, 40, 41, 42, 43, 44, 45],
                    itemStyle: {
                        normal: {
                            color: '#10c5d2'
                        }
                    },
                    markPoint: {
                        data: [
                            { type: 'max', name: '最大值' },
                            { type: 'min', name: '最小值' }
                        ]
                    },
                    markLine: {
                        data: [
                            // { type: 'average', name: '平均值' }
                        ]
                    }
                },
                {
                    name: '二氧化碳浓度',
                    type: 'line',
                    //stack: '总量',
                    // areaStyle: { normal: {} },
                    data: [23, 30, 20, 24, 25, 20, 15, 21, 22, 23, 24, 25],
                    itemStyle: {
                        normal: {
                            color: '#3240d2'
                        }
                    },
                    markPoint: {
                        data: [
                            { type: 'max', name: '最大值' },
                            { type: 'min', name: '最小值' }
                        ]
                    },
                    markLine: {
                        data: [
                            // { type: 'average', name: '平均值' }
                        ]
                    }
                },
                // {
                //     name: '氨气浓度',
                //     type: 'line',
                //     //stack: '总量',
                //     // areaStyle: { normal: {} },
                //     data: [10, 9, 15, 14, 9, 12, 15],
                //     itemStyle: {
                //         normal: {
                //             color: '#32c529'
                //         }
                //     },
                //     markPoint: {
                //         data: [
                //             { type: 'max', name: '最大值' },
                //             { type: 'min', name: '最小值' }
                //         ]
                //     },
                //     markLine: {
                //         data: [
                //             { type: 'average', name: '平均值' }
                //         ]
                //     }
                // },
                {
                    name: '硫化氢浓度',
                    type: 'line',
                    //stack: '总量',
                    // areaStyle: { normal: {} },
                    data: [0.5, 1, 0.2, 0.1, 0.2, 0.1, 0.5, 0.1, 0.2, 0.3, 0.4, 0.5],
                    itemStyle: {
                        normal: {
                            color: '#162542'
                        }
                    },
                    markPoint: {
                        data: [
                            { type: 'max', name: '最大值' },
                            { type: 'min', name: '最小值' }
                        ]
                    },
                    markLine: {
                        data: [
                            // { type: 'average', name: '平均值' }
                        ]
                    }
                }
            ]
        };
        echartsA.setOption(option);
    }
}

setInterval(function() {

    for (var i = 0; i < 5; i++) {
        data.shift();
        data.push(randomData());
    }

    myChart.setOption({
        series: [{
            data: data
        }]
    });
}, 1000);