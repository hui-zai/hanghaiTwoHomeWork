

define(function (require, exports, module) {
    var stpl = require('/index.vue');
    require('/IDM Download/SSM_BookSystem-master/SSM_BookSystem-master/计科166-许岸城-10/BookSystem_V0/src/main/webapp/index.css');
    var vueComponent = Vue.extend({
        template: stpl,
        data: function () {
            return {
                section: 0,
                timestamp: '',

                id: '',
                /**
                 * 图片容器
                 */
                logoContainer: null,
                orgCodePathCon: null,
                cardpositivePathCon: null,
                cardbackPathCon: null,
                cardhandPathCon: null,


                //是否显示详细信息
                isShowBaseInfoDetail: true,
                isShowOtherInfoDetail: true,
                isShowRegisterInfoDetail: true,
                isShowLegalInfoDetail: true,
                /**
                 * 图片是否上传标识
                 */
                OrgCodePathUp: false,
                CardpositivePathUp: false,
                CardbackPathUp: false,
                CardhandPathUp: false,
                /**
                 * 是否只读
                 */
                readyOnly: true,

                isFirstCompany: true,
                /**
                 * 基本信息-详情使用
                 */
                cusCurInfo: {},
                /**
                 * 其他信息-详情使用
                 */
                cusEnterpriseOtherInfo: {
                    isCooperationStatus: ''
                },
                /**
                 * 注册信息-详情使用
                 */
                registers: {},
                /**
                 * 法人信息-详情使用
                 */
                legals: {},
                /***********************  由于表单与详情共存，不能使用同一套数据，否则切换时会发生错乱
                 /**
                 * 基本信息-表单使用
                 */
                cusCurInfoForm: {},
                /**
                 * 其他信息-表单使用
                 */
                cusEnterpriseOtherInfoForm: {},
                /**
                 * 注册信息-表单使用
                 */
                registersForm: {},
                /**
                 * 法人信息-表单使用
                 */
                legalsForm: {},

                /**
                 * 营业额
                 */
                CusTurnovers: [],
                /**
                 * 企业资质
                 */
                CusQualifications: [],
                /**
                 * 说明
                 */
                OtherInfos: [],
                /**
                 * 融资
                 */
                StageInfos: [],

                /**
                 * 核心业务领域 枚举列表
                 */
                BusinessAreaEnums: [],
                /**
                 * 初始化企业规模枚举 枚举列表
                 */
                ScaleEnums: [],

                coopStatusClass1: '',
                coopStatusClass2: '',
                bearProjectClass1: '',
                bearProjectClass2: '',
                highNewTechnologyClass1: '',
                highNewTechnologyClass2: '',
                beWillingInvestClass1: '',
                beWillingInvestClass2: '',
            };
        },
        beforeRouteEnter: function (to, from, next) {
            // var title = to.name;
            next(function (vm) {
                vm.refresh();
                var queryTime = vm.$route.query.timestamp + '';

                if (queryTime)
                    vm.timestamp = queryTime;
                vm.id = vm.$route.query.id;
                vm.initPage();
            });
        },
        beforeRouteLeave: function (to, from, next) {
            var self = this;
            next(true);
        },
        mounted: function () {
            var self = this;
        },
        watch: {
            timestamp: function (val, oldVal) {
            },
        },
        components: {},
        methods: {
            refresh: function () {
                var self = this;
                self.section = 0;
                self.id = '';
                /**
                 * 图片容器
                 */
                self.logoContainer = null;
                self.orgCodePathCon = null;
                self.cardpositivePathCon = null;
                self.cardbackPathCon = null;
                self.cardhandPathCon = null;
                //是否显示详细信息
                self.isShowBaseInfoDetail = true;
                self.isShowOtherInfoDetail = true;
                self.isShowRegisterInfoDetail = true;
                self.isShowLegalInfoDetail = true;
                /**
                 * 图片是否上传标识
                 */
                self.OrgCodePathUp = false;
                self.CardpositivePathUp = false;
                self.CardbackPathUp = false;
                self.CardhandPathUp = false;
                /**
                 * 是否只读
                 */
                self.readyOnly = true;

                self.isFirstCompany = true;
                /**
                 * 基本信息-详情使用
                 */
                self.cusCurInfo = {};
                /**
                 * 其他信息-详情使用
                 */
                self.cusEnterpriseOtherInfo = {};
                /**
                 * 注册信息-详情使用
                 */
                self.registers = {};
                /**
                 * 法人信息-详情使用
                 */
                self.legals = {};
                /***********************  由于表单与详情共存，不能使用同一套数据，否则切换时会发生错乱
                 /**
                 * 基本信息-表单使用
                 */
                self.cusCurInfoForm = {};

                /**
                 * 其他信息-表单使用
                 */
                self.cusEnterpriseOtherInfoForm = {},
                    /**
                     * 注册信息-表单使用
                     */
                    self.registersForm = {};
                /**
                 * 法人信息-表单使用
                 */
                self.legalsForm = {};

                /**
                 * 营业额
                 */
                self.CusTurnovers = [];
                /**
                 * 企业资质
                 */
                self.CusQualifications = [];
                /**
                 * 其他信息
                 */
                self.OtherInfos = [];
                /**
                 * 融资
                 */
                self.StageInfos = [];
                /**
                 * 核心业务领域 枚举列表
                 */
                self.BusinessAreaEnums = [];

                /**
                 * 研发机构认定情况 枚举列表
                 */
                self.ResearchInstitutionStatusEnums = [];
                /**
                 * 初始化企业规模枚举 枚举列表
                 */
                self.ScaleEnums = [];

                $('#focusIndustry').empty();
                $('#bankType').empty();

            },
            /**
             * tab切换
             */
            toggleSection: function (section) {
                var self = this;
                self.section = section;
                //如果需要加载图片上传控件的需初始化
                switch (section) {
                    case 0: {
                        if (!self.isShowBaseInfoDetail) {
                            self.initBaseUploader();
                        }
                    }
                        break;
                    case 1: {
                        if (!self.isShowRegisterInfoDetail) {
                            self.initRegisterUploader();
                        }
                    }
                        break;
                    case 2: {
                        if (!self.isShowLegalInfoDetail) {
                            self.initLegalUploader();
                        }
                    }
                        break;
                }
            },
            /**
             * 修改切换按钮
             */
            modifyDo: function () {
                var self = this;
                switch (self.section) {
                    case 0: {
                        self.isShowBaseInfoDetail = false;
                        self.initBaseUploader();
                    }
                        break;
                    case 1: {
                        self.isShowRegisterInfoDetail = false;
                        self.initRegisterUploader();
                    }
                        break;
                    case 2: {
                        self.isShowLegalInfoDetail = false;
                        self.initLegalUploader();
                    }
                        break;
                }
                this.isShowBaseInfoDetail = false;
                this.initBaseUploader();
            },

            /**
             * *********************************************表单部分
             */
            initPage: function () {
                var self = this;

                //勾选
                $(".xw_tick").click(function () {
                    $(this).toggleClass("tickOn");
                });
                $(".xw_tickB").click(function () {
                    $(this).toggleClass("tickBOn");
                });
                //下拉输入查询框事件
                $("div.mohusearch").hover(function () {
                    $(this).find("div.xw_searchDoult").slideDown('fast');
                }, function () {
                    $(this).find("div.xw_searchDoult").slideUp();
                });
                // 有样式冲突
                // $("div.xw_Service").click(function () {
                //     $("div.xw_Service").removeClass("Serviced");
                //     $(this).addClass("Serviced");
                //
                // });
                $("div.xlBar").hover(function () {
                    $(this).find("div.xw_jieguo").slideDown('fast');
                }, function () {
                    $(this).find("div.xw_jieguo").slideUp();
                });


                /** 判断第一次操作*/
                DataHandler.existCompany(function (data) {
                    self.isFirstCompany = !data;
                });
                DataHandler.findInfo(self.id, function (resp) {
                    console.log(resp);

                    // 对公司信息的其他信息页面的修改-单选添加默认样式，否则在新增阶段，单选框将不会被自动勾选。
                    if (resp.cusEnterpriseOtherInfo.isHighNewTechnology == 1) {
                        self.highNewTechnologyClass1 = 'Serviced';
                        self.highNewTechnologyClass2 = '';
                    } else if (resp.cusEnterpriseOtherInfo.isHighNewTechnology == 2) {
                        self.highNewTechnologyClass1 = '';
                        self.highNewTechnologyClass2 = 'Serviced';
                    } else {
                        cusEnterpriseOtherInfo.isHighNewTechnology = 2;
                        self.highNewTechnologyClass1 = '';
                        self.highNewTechnologyClass2 = 'Serviced';
                    }

                    if (resp.cusEnterpriseOtherInfo.isCooperationStatus == 1) {
                        self.coopStatusClass1 = 'Serviced';
                        self.coopStatusClass2 = '';
                    } else if (resp.cusEnterpriseOtherInfo.isCooperationStatus == 2) {
                        self.coopStatusClass1 = '';
                        self.coopStatusClass2 = 'Serviced';
                    } else {
                        $("#isCooperationStatus").val(2);
                        cusEnterpriseOtherInfo.isCooperationStatus = 2;
                        self.coopStatusClass1 = '';
                        self.coopStatusClass2 = 'Serviced';
                    }

                    if (resp.cusEnterpriseOtherInfo.isBearProject == 1) {
                        self.bearProjectClass1 = 'Serviced';
                        self.bearProjectClass2 = '';
                    } else if (resp.cusEnterpriseOtherInfo.isBearProject == 2) {
                        self.bearProjectClass1 = '';
                        self.bearProjectClass2 = 'Serviced';
                    } else {
                        cusEnterpriseOtherInfo.isBearProject = 2;
                        self.bearProjectClass1 = '';
                        self.bearProjectClass2 = 'Serviced';
                    }

                    if (resp.cusEnterpriseOtherInfo.isBeWillingInvest == 1) {
                        self.beWillingInvestClass1 = 'Serviced';
                        self.beWillingInvestClass2 = '';
                    } else if (resp.cusEnterpriseOtherInfo.isBeWillingInvest == 2) {
                        self.beWillingInvestClass1 = '';
                        self.beWillingInvestClass2 = 'Serviced';
                    } else {
                        cusEnterpriseOtherInfo.isBeWillingInvest = 2;
                        self.beWillingInvestClass1 = '';
                        self.beWillingInvestClass2 = 'Serviced';
                    }

                    self.readyOnly = resp['readyOnly'];
                    self.isShowBaseInfoDetail = !resp['editBaseInfo'] || self.readyOnly;
                    self.isShowRegisterInfoDetail = !resp['editRegisterInfo'] || self.readyOnly;
                    self.isShowLegalInfoDetail = !resp['editLegal'] || self.readyOnly;

                    self.OrgCodePathUp = resp['OrgCodePathUp'];
                    self.CardpositivePathUp = resp['CardpositivePathUp'];
                    self.CardbackPathUp = resp['CardbackPathUp'];
                    self.CardhandPathUp = resp['CardhandPathUp'];
                    self.cusCurInfo = resp['cusCertificationForm'];
                    self.cusEnterpriseOtherInfo = resp['cusEnterpriseOtherInfo'];

                    self.registers = resp['registerInfoForm'];
                    self.legals = resp['legalInfoForm'];
                    //深复制对象
                    self.cusCurInfoForm = $.extend(true, {}, self.cusCurInfo);
                    self.cusEnterpriseOtherInfosForm = $.extend(true, {}, self.cusEnterpriseOtherInfo);

                    $('#logoPic').attr('src', self.cusCurInfoForm['logoPath']);
                    self.cusCurInfoForm['logoPath'] = '';
                    self.registers['regisCapital'] = self.registers['regisCapital'] / 1000000.0;
                    self.registersForm = $.extend(true, {}, self.registers);
                    $('#orgCodePic').attr('src', self.registersForm['orgCodePath']);
                    $('#regisTime').val(self.registersForm['regisTime'].substring(0, 10));
                    self.registersForm['orgCodePath'] = '';

                    self.legalsForm = $.extend(true, {}, self.legals);
                    $('#cardpositivePic').attr('src', self.legalsForm['cardpositivePath']);
                    $('#cardbackPic').attr('src', self.legalsForm['cardbackPath']);
                    $('#cardhandPic').attr('src', self.legalsForm['cardhandPath']);
                    self.legalsForm['cardpositivePath'] = '';
                    self.legalsForm['cardbackPath'] = '';
                    self.legalsForm['cardhandPath'] = '';
                    // self.cusCurInfoForm['linkMan'] = resp.linkMan;

                    $('#provinceId').val(self.cusCurInfoForm['provinceId']);
                    $('#cityId').val(self.cusCurInfoForm['cityId']);
                    $('#regionId').val(self.cusCurInfoForm['regionId']);
                    $('#focusIndustry').val(self.cusCurInfoForm['focusIndustry']);
                    // $("#linkMan").val(resp.linkMan);

                    /**
                     * 地址选择器
                     */
                    UtilHandler.initAddress(
                        $('#provinceName'),
                        $('#cityName'),
                        $('#regionName'),
                        $('#provinceId'),
                        $('#cityId'),
                        $('#regionId')
                    );

                    /**
                     * 选择框
                     */
                    adminSystem.initEnumSelect([
                        /*** 所属行业*/
                        {
                            tabName: 'T_CUS_INDUSTRY',
                            colName: 'I_INDUSTRY_CATEGORY',
                            selectObj: $('#focusIndustry'),
                            defaultValue: self.cusCurInfo['focusIndustry'],
                            additionValue: '',
                            additionName: '请选择'
                        },
                        /*** 高新技术级别*/
                        {
                            tabName: 'T_CUS_ENTERPRISE_OTHER_INFO',
                            colName: 'I_HIGH_NEW_TECHNOLOGY',
                            selectObj: $('#levelHighNew'),
                            defaultValue: self.cusEnterpriseOtherInfo['levelHighNew'],
                            additionValue: '',
                            additionName: '请选择'
                        },
                        /** 开户银行*/
                        {
                            tabName: 'T_CUS_CERTIFICATION',
                            colName: 'I_BANK_TYPE',
                            selectObj: $('#bankType'),
                            defaultValue: self.registers['bankType'],
                            additionValue: '',
                            additionName: '请选择'
                        }], function () {
                    });

                    DataHandler.findEnum(['T_CUS_CERTIFICATION', 'T_CUS_CERTIFICATION'], ['I_BUSINESS_AREA', 'S_SCALE'], function (da) {
                        self.BusinessAreaEnums = da.result["T_CUS_CERTIFICATION-I_BUSINESS_AREA"]["sEnumMapping"];
                        self.ScaleEnums = da.result["T_CUS_CERTIFICATION-S_SCALE"]["sEnumMapping"]
                    });

                    DataHandler.findEnum(['T_CUS_ENTERPRISE_OTHER_INFO'], ['I_RESEARCH_INSTITUTION_STATUS'], function (da) {
                        self.ResearchInstitutionStatusEnums = da.result["T_CUS_ENTERPRISE_OTHER_INFO-I_RESEARCH_INSTITUTION_STATUS"]["sEnumMapping"];
                        // self.ScaleEnums = da.result["T_CUS_CERTIFICATION-S_SCALE"]["sEnumMapping"]
                    });

                    //
                    /** 注册时间控件*/
                    $('#regisTime').datepicker({
                        format: "yyyy-mm-dd"
                    });
                    $("#becomeHighNewTime").datepicker({
                        format: "yyyy-mm-dd"
                    });

                    //初始化列表
                    DataHandler.findCusTurnover(self.id, function (da) {
                        self.CusTurnovers = da;
                    });
                    DataHandler.findCusQualification(self.id, function (da) {
                        self.CusQualifications = da;
                    });
                    DataHandler.findOtherInfos(self.id, function (da) {
                        self.OtherInfos = da;
                    });
                    DataHandler.findStageInfos(self.id, function (da) {
                        self.StageInfos = da;
                    });

                    if (!self.isShowBaseInfoDetail) {
                        self.initBaseUploader();
                    }
                });

            },
            /** 初始化图片控件*/
            initBaseUploader: function () {
                var self = this;
                //公司logo
                if (self.logoContainer == null) {
                    self.logoContainer = UtilHandler.initUploader($('#logoContainer'), function (data) {
                        // console.log(JSON.stringify(data));
                        self.cusCurInfoForm.logoPath = data.attachmentId;
                        $('#logoContainer .logoPic').attr('src', data.url);
                    });
                }

            },
            /** 初始化图片控件*/
            initRegisterUploader: function () {
                var self = this;
                //营业执照 扫描件
                if (self.orgCodePathCon == null) {
                    self.orgCodePathCon = UtilHandler.initUploader($('#orgCodePathCon'), function (data) {
                        $('#orgCodePathCon .zzPic').attr('src', data.url);
                        self.registersForm.orgCodePath = data.attachmentId;
                    });
                }

            },
            /** 初始化法人图片控件*/
            initLegalUploader: function () {
                var self = this;
                //法人证件正面
                if (self.cardpositivePathCon == null) {
                    self.cardpositivePathCon = UtilHandler.initUploader($('#cardpositivePathCon'), function (data) {
                        // console.log(JSON.stringify(data));
                        $('#cardpositivePathCon .idPic').attr('src', data.url);
                        self.legalsForm.cardpositivePath = data.attachmentId;
                    });
                }

                //法人证件反面
                if (self.cardbackPathCon == null) {
                    self.cardbackPathCon = UtilHandler.initUploader($('#cardbackPathCon'), function (data) {
                        // console.log(JSON.stringify(data));
                        $('#cardbackPathCon .idPic').attr('src', data.url);
                        self.legalsForm.cardbackPath = data.attachmentId;
                    });
                }
                //手持证件
                if (self.cardhandPathCon == null) {
                    self.cardhandPathCon = UtilHandler.initUploader($('#cardhandPathCon'), function (data) {
                        // console.log(JSON.stringify(data));
                        $('#cardhandPathCon .idPic').attr('src', data.url);
                        self.legalsForm.cardhandPath = data.attachmentId;
                    });
                }

            },
            /**
             * 企业基本信息
             */
            commitBaseInfo: function () {
                var self = this;
                var $form = $('#baseInfo');
                if ($form.valid()) {

                    self.cusCurInfoForm['provinceName'] = $('#provinceName').val();
                    self.cusCurInfoForm['cityName'] = $('#cityName').val();
                    self.cusCurInfoForm['regionName'] = $('#regionName').val();
                    self.cusCurInfoForm['provinceId'] = $('#provinceId').val();
                    self.cusCurInfoForm['cityId'] = $('#cityId').val();
                    self.cusCurInfoForm['regionId'] = $('#regionId').val();
                    self.cusCurInfoForm['focusIndustry'] = $('#focusIndustry').val();
                    self.cusCurInfoForm['linkMan'] = $('#linkMan').val();

                    DataHandler.commitInfo("/admin/customer/commitBaseInfo", self.cusCurInfoForm, function (data) {
                        if (data.type = 'success') {
                            self.isFirstCompany = false;
                            msgBox.tips("保存成功");
                            // console.log(JSON.stringify(data.result));
                            var info = data.result;
                            info["logoPath"] = $('#logoPic').attr('src');
                            self.cusCurInfo = info;
                            self.isShowBaseInfoDetail = true;

                            self.$root.app.remark = self.cusCurInfoForm['companyDesc'];
                            self.$root.app.companyName = self.cusCurInfoForm['name'];
                            self.$root.app.photoUrl = self.cusCurInfo['logoPath'];
                        } else {
                            msgBox.warn(data.content);
                        }
                    });
                } else {
                    msgBox.warn("请先将必填字段填写完整！");
                    return;
                }
            },


            /**
             * 注册信息
             */
            commitRegisterInfo: function () {
                var self = this;
                var $form = $('#registerInfo');
                if ($form.valid()) {

                    var orgCodePath = self.registersForm.orgCodePath;
                    if ((orgCodePath == undefined || orgCodePath == '') && !self.OrgCodePathUp) {
                        msgBox.warn("请先上传营业执照扫描件");
                        return;
                    }
                    self.registersForm['bankType'] = $('#bankType').val();
                    self.registersForm['regisTime'] = $('#regisTime').val();
                    // console.log(JSON.stringify(self.registersForm));
                    DataHandler.commitInfo("/admin/customer/commitRegisterInfo", self.registersForm, function (data) {
                        if (data.type = 'success') {
                            self.isFirstCompany = false;
                            msgBox.tips("保存成功");
                            var info = data.result;
                            info["orgCodePath"] = $('#orgCodePic').attr('src');
                            self.registers = info;
                            self.isShowRegisterInfoDetail = true;
                        } else {
                            msgBox.warn(data.content);
                        }
                    });
                } else {
                    msgBox.warn("请先将必填字段填写完整！");
                    return;
                }
            },
            /**
             * 法人信息
             */
            commitRegalInfo: function () {
                var self = this;
                var $form = $('#legalInfo');
                if ($form.valid()) {
                    var cardpositivePath = self.legalsForm.cardpositivePath,
                        cardbackPath = self.legalsForm.cardbackPath,
                        cardhandPath = self.legalsForm.cardhandPath;
                    if ((cardpositivePath == undefined || cardpositivePath == '') && !self.CardpositivePathUp) {
                        msgBox.warn("请先上传法人身份证正面照片");
                        return;
                    }
                    if ((cardbackPath == undefined || cardbackPath == '') && !self.CardbackPathUp) {
                        msgBox.warn("请先上传法人身份证反面照片");
                        return;
                    }
                    if ((cardhandPath == undefined || cardhandPath == '') && !self.CardhandPathUp) {
                        msgBox.warn("请先上传法人手持身份证照片");
                        return;
                    }
                    // console.log(JSON.stringify(self.legalsForm));
                    DataHandler.commitInfo("/admin/customer/commitLegalInfo", $form.serializeArray(), function (data) {
                        if (data.type = 'success') {
                            self.isFirstCompany = false;
                            msgBox.tips("保存成功");
                            var info = data.result;
                            info["cardpositivePath"] = $('#cardpositivePic').attr('src');
                            info["cardbackPath"] = $('#cardbackPic').attr('src');
                            info["cardhandPath"] = $('#cardhandPic').attr('src');

                            self.legals = info;
                            self.isShowLegalInfoDetail = true;
                        } else {
                            msgBox.warn(data.content);
                        }
                    });
                } else {
                    msgBox.warn("请先将必填字段填写完整！");
                    return;
                }
            },
            /**
             * ****************************************其他信息部分
             */
            saveHighNewTechnology: function (index) {
                var self = this;
                var $form = $('#cusEnterpriseOtherInfo').serializeArray();

                /**
                 * 对某些数据进行手动更新，否则保存后的详情页的信息中，这些字段可能不会更新
                 */
                this.cusEnterpriseOtherInfo.becomeHighNewTime = $form[1].value;
                this.cusEnterpriseOtherInfo.researchInstitutionStatusText = $("#researchInstitutionStatusEnum .on").text();
                this.cusEnterpriseOtherInfo.levelHighNewText = $("#levelHighNew").find("option:selected").text();
                this.cusEnterpriseOtherInfo.bearProjectDetail = $("#bearProjectDetail").val();
                this.cusEnterpriseOtherInfo.cooperationDetail = $("#cooperationDetail").val();

                /**
                 * 对下拉框进行判空操作
                 */
                if ($form[2].value == "" || $form[2].value == undefined || $form[2].value == null) {
                    $form[2].value = 0;
                    if ($form[0].value == 1) {
                        msgBox.warn("高新技术级别不能为空");
                        return;
                    }
                }
                if ($form !== null) {
                    DataHandler.commitInfo("/admin/customer/saveHighNewTechnology", $form, function (data) {
                        if (data.type = 'success') {
                            self.isFirstCompany = false;
                            msgBox.tips("保存成功");

                            //切换到详情页
                            self.isShowOtherInfoDetail = true;
                        } else {
                            msgBox.warn(data.content);
                        }
                    });
                }
                else {
                    msgBox.warn("请先将必填字段填写完整！");
                    return;
                }
            },

            /**
             * ****************************************营业额部分
             */
            addCusTurnover: function (index) {
                var self = this;
                if (!self.isFirstCompany) {
                    var id = null;
                    if (index != undefined) {
                        id = self.CusTurnovers[index]['id'];
                    }
                    DataHandler.addCusTurnover(id, function (data) {
                        if (id == null) {
                            self.CusTurnovers.unshift(data);
                        } else {
                            self.CusTurnovers.splice(index, 1, data);
                        }

                    });
                } else {
                    msgBox.warn("请先完善企业基本信息和注册信息！");
                }
            },

            /**
             * ****************************************企业资质部分
             */
            addCusQualification: function (index) {
                var self = this;
                if (!self.isFirstCompany) {
                    var id = null;
                    if (index != undefined) {
                        id = self.CusQualifications[index]['id'];
                    }
                    DataHandler.addCusQualification(id, function (data) {
                        if (id == null) {
                            self.CusQualifications.unshift(data);
                        } else {
                            self.CusQualifications.splice(index, 1, data);
                        }

                    });
                } else {
                    msgBox.warn("请先完善企业基本信息和注册信息！");
                }
            },


            delCusTurnover: function (index) {
                var vue = this;
                if (vue.readyOnly == 'true') {
                    msgBox.warn("您不能进行此操作！");
                    return;
                }
                if (vue.CusTurnovers.length < index) {
                    msgBox.warn("删除失败！");
                    return;
                }
                msgBox.confirm({
                    title: '提示', msg: '确认要删除吗?', callback: function (btnType) {
                        if (btnType != msgBox.ButtonType.OK) {
                            return;
                        }
                        var id = vue.CusTurnovers[index]["id"];
                        DataHandler.deleteCusTurnover([{name: "id", value: id}], function (data) {
                            if (data.type == 'success') {
                                msgBox.tips("删除成功");
                                vue.CusTurnovers.splice(index, 1);
                                if (vue.CusTurnovers.length <= 0) {
                                    vue.CusTurnovers = [];
                                }
                            } else {
                                msgBox.warn(data.content);
                            }
                        });
                    }
                });
            }
            ,

            /**
             * ****************************************其他说明部分
             */
            addCusOtherInfo: function (index) {
                var self = this;
                if (!self.isFirstCompany) {
                    var id = null;
                    if (index != undefined) {
                        id = self.OtherInfos[index]['id'];
                    }
                    DataHandler.addCusOtherInfo(id, function (data) {
                        if (id == null) {
                            self.OtherInfos.unshift(data);
                        } else {
                            self.OtherInfos.splice(index, 1, data);
                        }

                    });
                } else {
                    msgBox.warn("请先完善企业基本信息和注册信息！");
                }
            }
            ,

            delCusOtherInfo: function (index) {
                var vue = this;
                if (vue.readyOnly == 'true') {
                    msgBox.warn("您不能进行此操作！");
                    return;
                }
                if (vue.OtherInfos.length < index) {
                    msgBox.warn("删除失败！");
                    return;
                }
                msgBox.confirm({
                    title: '提示', msg: '确认要删除吗?', callback: function (btnType) {
                        if (btnType != msgBox.ButtonType.OK) {
                            return;
                        }
                        var id = vue.OtherInfos[index]["id"];
                        DataHandler.deleteOtherInfo([{name: "id", value: id}], function (data) {
                            if (data.type == 'success') {
                                msgBox.tips("删除成功");
                                vue.OtherInfos.splice(index, 1);
                                if (vue.OtherInfos.length <= 0) {
                                    vue.OtherInfos = [];
                                }
                            } else {
                                msgBox.warn(data.content);
                            }
                        });
                    }
                });
            }
            ,

            /**
             * ****************************************融资阶段
             */
            addFinancelStage: function (index) {
                var self = this;
                if (!self.isFirstCompany) {
                    var id = null;
                    if (index != undefined) {
                        id = self.StageInfos[index]['id'];
                    }
                    DataHandler.addFinancelStage(id, function (data) {
                        if (id == null) {
                            self.StageInfos.unshift(data);
                        } else {
                            self.StageInfos.splice(index, 1, data);
                        }

                    });
                } else {
                    msgBox.warn("请先完善企业基本信息和注册信息！");
                }
            }
            ,
            delFinancelStage: function (index) {
                var vue = this;
                if (vue.readyOnly == 'true') {
                    msgBox.warn("您不能进行此操作！");
                    return;
                }

                if (vue.StageInfos.length < index) {
                    msgBox.warn("删除失败！");
                    return;
                }
                msgBox.confirm({
                    title: '提示', msg: '确认要删除吗?', callback: function (btnType) {
                        if (btnType != msgBox.ButtonType.OK) {
                            return;
                        }
                        var id = vue.StageInfos[index]["id"];
                        DataHandler.deleteStageInfos([{name: "id", value: id}], function (data) {
                            if (data.type == 'success') {
                                msgBox.tips("删除成功");
                                vue.StageInfos.splice(index, 1);
                                if (vue.StageInfos.length <= 0) {
                                    vue.StageInfos = [];
                                }
                            } else {
                                msgBox.warn(data.content);
                            }
                        });
                    }
                });
            }
            ,

            /**
             * 图片查看器
             * @param path  图片地址
             * @param name  图片名称
             */
            showBigPhoto: function (path, name) {
                var json = {
                    "title": "说明图片", //相册标题
                    "id": 123, //相册id
                    "start": 0, //初始显示的图片序号，默认0
                    "data": [   //相册包含的图片，数组格式
                        {
                            "alt": name,
                            "pid": 666, //图片id
                            "src": path, //原图地址
                            "thumb": path //缩略图地址
                        }
                    ]
                }
                layer.photos({
                    photos: json //格式见API文档手册页
                    //  ,anim: 1 //0-6的选择，指定弹出图片动画类型，默认随机
                });
            },
            choiceCooperationStatus: function (idx) {
                this.cusEnterpriseOtherInfo.isCooperationStatus = idx;

                if (idx == 1) {
                    this.coopStatusClass1 = 'Serviced';
                    this.coopStatusClass2 = '';
                } else if (idx == 2) {
                    this.coopStatusClass1 = '';
                    this.coopStatusClass2 = 'Serviced';
                } else {
                    this.coopStatusClass1 = '';
                    this.coopStatusClass2 = '';
                }
            },
            choiceBearProject: function (idx) {
                this.cusEnterpriseOtherInfo.isBearProject = idx;
                if (idx == 1) {
                    this.bearProjectClass1 = 'Serviced';
                    this.bearProjectClass2 = '';
                } else if (idx == 2) {
                    this.bearProjectClass1 = '';
                    this.bearProjectClass2 = 'Serviced';
                } else {
                    this.bearProjectClass1 = '';
                    this.bearProjectClass2 = '';
                }
            },
            choiceHighNewTechnology(idx){
                this.cusEnterpriseOtherInfo.isHighNewTechnology = idx;
                if (idx == 1) {
                    this.highNewTechnologyClass1 = 'Serviced';
                    this.highNewTechnologyClass2 = '';
                } else if (idx == 2) {
                    this.highNewTechnologyClass1 = '';
                    this.highNewTechnologyClass2 = 'Serviced';
                } else {
                    this.highNewTechnologyClass1 = '';
                    this.highNewTechnologyClass2 = '';
                }
            },
            choiceBeWillingInvest(idx){
                this.cusEnterpriseOtherInfo.isBeWillingInvest = idx;
                if (idx == 1) {
                    this.beWillingInvestClass1 = 'Serviced';
                    this.beWillingInvestClass2 = '';
                } else if (idx == 2) {
                    this.beWillingInvestClass1 = '';
                    this.beWillingInvestClass2 = 'Serviced';
                } else {
                    this.beWillingInvestClass1 = '';
                    this.beWillingInvestClass2 = '';
                }
            }
        }
    });
    /** 数据处理器 */
    var DataHandler = (function () {
        return {
            /**
             * 编辑时获取信息
             *
             * @param callback
             */
            findInfo: function (param, callback) {
                var params = [{name: "adminCusCerId", value: param}];
                $.get(path + "/admin/customer/companyInfoDetail", params, function (data) {
                    if (data.type == 'success') {
                        callback(data.result);
                    } else {
                        msgBox.tips("获取数据失败！");
                    }

                });
            },

            /**
             * 判断能否进行新增创始团队，说明，融资的新增
             */
            existCompany: function (callback) {
                $.get(path + "/admin/customer/existCompany", null, function (data) {
                    callback(data.result);
                });
            },
            /**
             * 提交表单
             * @param param
             * @param callback
             */
            commitInfo: function (url, param, callback) {
                $.post(path + url, param, function (data) {
                    callback(data);
                });
            },

            /**
             * 营业额部分新增，编辑弹窗
             * @param id
             * @param callBack
             */
            addCusTurnover: function (id, callBack) {
                if (id == null) {
                    id = "";
                }
                var url = path + "/admin/cusTurnover/dialog.html?id=" + id;
                msgBox.exWindow.open({
                    url: url,
                    width: '550px',
                    height: '275px',
                    title: '<strong style="color:#e94b14;">营业额</strong>',
                    extraParams: '',
                    close: function (da) {
                        if (da != undefined && da != "") {
                            callBack(da);
                        }
                    }
                });
            },

            /**
             * 企业资质部分新增，编辑弹窗
             * @param id
             * @param callBack
             */
            addCusQualification: function (id, callBack) {
                if (id == null) {
                    id = "";
                }
                var url = path + "/admin/cusQualification/dialog.html?id=" + id;
                msgBox.exWindow.open({
                    url: url,
                    width: '550px',
                    height: '400px',
                    title: '<strong style="color:#e94b14;">企业资质</strong>',
                    extraParams: '',
                    close: function (da) {
                        if (da != undefined && da != "") {
                            callBack(da);
                        }
                    }
                });
            },

            saveHighNewTechnology: function (id, callBack) {
                if (id == null) {
                    id = "";
                }
                var url = path + "/admin/cusQualification/dialog.html?id=" + id;
                msgBox.exWindow.open({
                    url: url,
                    width: '550px',
                    height: '400px',
                    title: '<strong style="color:#e94b14;">企业资质</strong>',
                    extraParams: '',
                    close: function (da) {
                        if (da != undefined && da != "") {
                            callBack(da);
                        }
                    }
                });
            },

            /**
             * 查询营业额
             *
             * @param param
             * @param callback
             */
            findCusTurnover: function (id, callback) {
                if (id == null) {
                    id = '';
                }
                $.get(path + "/admin/cusTurnover/findList?id=" + id, null, function (data) {
                    callback(data);
                });
            },
            /**
             * 查询企业资质
             *
             * @param param
             * @param callback
             */
            findCusQualification: function (id, callback) {
                if (id == null) {
                    id = '';
                }
                $.get(path + "/admin/cusQualification/findList?id=" + id, null, function (data) {
                    callback(data);
                });
            },
            /**
             * 删除营业额
             *
             * @param param
             * @param callback
             */
            deleteCusTurnover: function (param, callback) {
                $.post(path + "/admin/cusTurnover/delete", param, function (data) {
                    callback(data);
                });
            },

            /**
             * 增加说明
             * @param id
             * @param callBack
             */
            addCusOtherInfo: function (id, callBack) {
                if (id == null) {
                    id = "";
                }
                var url = path + "/admin/cusOtherInfo/dialog.html?id=" + id;
                msgBox.exWindow.open({
                    url: url,
                    width: '550px',
                    height: '375px',
                    title: '<strong style="color:#e94b14;">添加说明</strong>',
                    extraParams: '',
                    close: function (da) {
                        if (da != undefined && da != "") {
                            callBack(da);
                        }
                    }
                });
            },

            /**
             * 查询当前企业的说明信息列表
             *
             * @param param
             * @param callback
             */
            findOtherInfos: function (id, callback) {
                if (id == null) {
                    id = "";
                }
                $.get(path + "/admin/cusOtherInfo/findList?id=" + id, null, function (data) {
                    callback(data);
                });
            },
            /**
             * 删除当前企业的说明信息列表
             *
             * @param param
             * @param callback
             */
            deleteOtherInfo: function (param, callback) {
                $.post(path + "/admin/cusOtherInfo/delete", param, function (data) {
                    callback(data);
                });
            },


            /** 增加融资*/
            addFinancelStage: function (id, callBack) {
                if (id == null) {
                    id = "";
                }
                var url = path + "/admin/financelStage/dialog.html?&id=" + id;
                msgBox.exWindow.open({
                    url: url,
                    width: '800px',
                    height: '260px',
                    title: '<strong style="color:#e94b14;">添加融资阶段</strong>',
                    extraParams: '',
                    close: function (da) {
                        if (da != undefined && da != "") {
                            callBack(da);
                        }
                    }
                });
            },
            /**
             * 查询当前企业的融资信息列表
             *
             * @param param
             * @param callback
             */
            findStageInfos: function (id, callback) {
                if (id == null) {
                    id = "";
                }
                $.get(path + "/admin/financelStage/findList?id=" + id, null, function (data) {
                    callback(data);
                });
            },

            /**
             * 删除当前企业的融资信息列表
             *
             * @param param
             * @param callback
             */
            deleteStageInfos: function (param, callback) {
                $.post(path + "/admin/financelStage/delete", param, function (data) {
                    callback(data);
                });
            },
            /**
             *  查询枚举，单选用
             * @param tabName   数组
             * @param colName   数组
             * @param callback
             */
            findEnum: function (tabName, colName, callback) {
                var whsEnum = [];
                for (var i = 0; i < tabName.length; i++) {
                    whsEnum.push({
                        "tabName": tabName[i],
                        "colName": colName[i]
                    });
                }
                var param = [
                    {name: "whsEnum", value: JSON.stringify(whsEnum)},
                    {name: "type", value: 2},
                ];
                $.post(path + "/pub/enumMgr/findEnumListBusi", param, function (data) {
                    callback(data);
                });
            }
        };
    })();

    var UtilHandler = (function () {
        return {
            /**
             * 初始化地址选择器
             *
             * @param $selectPrivince  省控件(name)    （select元素）
             * @param $selectCity      市控件(name)    （select元素）
             * @param $selectCounty    区控件(name)    （select元素）
             * @param $privinceIdEle   省id            input[hidden]元素  [可选]
             * @param $cityIdEle       市id            input[hidden]元素  【可选】
             * @param $countyIdEle     区id            input[hidden]元素  【可选】
             */
            initAddress: function ($selectPrivince, $selectCity, $selectCounty, $privinceIdEle, $cityIdEle, $countyIdEle) {
                /** 初始化地理信息下拉框 */
                //初始化省控件
                address.findProvince(function (result) {
                    // console.log(JSON.stringify(result));
                    var options = "<option value=''>" + "请选择" + "</option>";
                    for (var i in result) {
                        var option = "<option value='" + result[i].name + "' data-code='" + result[i].addrCode + "'>" + result[i].name + "</option>";

                        if ($selectPrivince.attr('initValue') == result[i].name) {
                            option = "<option value='" + result[i].name + "' data-code='" + result[i].addrCode + "' selected='selected'>" + result[i].name + "</option>";
                        }
                        options += option;
                    }
                    $selectPrivince.html(options);
                    $selectCity.html("<option value=''>" + "请选择" + "</option>");
                    $selectCounty.html("<option value=''>" + "请选择" + "</option>");
                    if ($privinceIdEle.val() != "") {
                        initCity($privinceIdEle.val());
                    }
                    if ($cityIdEle.val() != "") {
                        initCounty($cityIdEle.val());
                    }
                });

                //当没有省Id时，初始化控件
                if ($privinceIdEle.val() == "" && $selectCity.attr('initValue') != "") {
                    var city = $selectCity.attr('initValue');
                    $selectCity.html("<option value='" + city + "' checked='checked' data-code=''>" + city + "</option>");
                }
                // if($cityIdEle.val()!=""){
                //     initCounty($cityIdEle.val());
                // }
                //当没有市Id时，初始化控件
                if ($cityIdEle.val() == "" && $selectCounty.attr('initValue') != "") {
                    var county = $selectCounty.attr('initValue');
                    $selectCounty.html("<option value='" + county + "' checked='checked' data-code=''>" + county + "</option>");
                }

                //市控件随着省控件而变化
                $selectPrivince.change(function () {
                    var provinceCode = $(this).find("option:selected").attr('data-code');
                    if ($privinceIdEle != undefined) {
                        $selectCity.removeAttr('data-rule-required');
                        $privinceIdEle.val(provinceCode);
                        $cityIdEle.val('');
                        $countyIdEle.val('');
                        // if(provinceCode == '000000' || provinceCode == '710000'){
                        //     $selectCity.removeAttr('data-rule-required');
                        // }else {
                        //     $selectCity.attr('data-rule-required',true);
                        // }
                    }
                    initCity(provinceCode);
                });
                //初始化区控件
                $selectCity.change(function () {
                    var cityCode = $(this).find("option:selected").attr('data-code');
                    if ($cityIdEle != undefined) {
                        $cityIdEle.val(cityCode);
                        $countyIdEle.val('');
                    }
                    initCounty(cityCode);
                });

                $selectCounty.change(function () {
                    var countyCode = $(this).find("option:selected").attr('data-code');
                    if ($countyIdEle != undefined) {
                        $countyIdEle.val(countyCode);
                    }
                });

                function initCity(provinceCode) {
                    address.findCity(provinceCode, function (result) {
                        var options = "<option value=''>" + "请选择" + "</option>";
                        for (var i in result) {
                            var option = "<option value='" + result[i].name + "' data-code='" + result[i].addrCode + "'>" + result[i].name + "</option>";
                            if ($selectCity.attr('initValue') == result[i].name) {
                                option = "<option value='" + result[i].name + "' data-code='" + result[i].addrCode + "' selected='selected'>" + result[i].name + "</option>";
                                $cityIdEle.val(result[i].addrCode);
                            }
                            options += option;
                        }
                        $selectCity.html(options);
                        var cityCode = $selectCity.find("option:selected").attr('data-code');
                        initCounty(cityCode);
                    });
                };

                function initCounty(cityCode) {
                    address.findCounty(cityCode, function (result) {
                        var options = "<option value=''>" + "请选择" + "</option>";
                        for (var i in result) {
                            var option = "<option value='" + result[i].name + "' data-code='" + result[i].addrCode + "'>" + result[i].name + "</option>";
                            if ($selectCounty.attr('initValue') == result[i].name) {
                                option = "<option value='" + result[i].name + "' data-code='" + result[i].addrCode + "' selected='selected'>" + result[i].name + "</option>";
                                $countyIdEle.val(result[i].addrCode);
                            }
                            options += option;
                        }
                        $selectCounty.html(options);
                    });
                };
            },

            /**
             * 初始化图片上传控件
             * @param btn       控件选择器
             * @param callback  回调函数
             */
            initUploader: function (btn, callback) {
                return new Uploader({
                    server: path + '/attachment/fileUpload.json', //上传服务地址
                    pickerSelector: btn, //选择文件按钮选择器
                    multiplePick: true, //默认：false，是否支持多选
                    autoUpload: true, //默认：false，是否选择后自动上传

                    accept: uploadAcceptImage,
                    formData: {
                        isDB: 1 // 上传文件时保存数据到附件表
                    }, //默认：{}，上传附带其他表单参数
                    fileFieldId: 'files', //默认：file，文件域名称
                    fileSingleSizeLimit: undefined, //默认：undefined，单文件大小限制
                    // 文件加入队列事件
                    onFileQueued: function (file) {
                        layer.load();
                    },
                    onValidateError: function (errorType, errorMsg) {
                        msgBox.warn("图片校验失败");
                    }, //文件校验不通过事件
                    onFileUploadError: function (file, errorCode) {
                        msgBox.warn("图片上传失败");
                    }, //文件上传出错事件
                    onFileUploadSuccess: function (file, response) {
                        if (response.type == 'success') {
                            //  var attachment = response.result[0];
                            callback(response.result[0]);
                        }
                    },//文件上传成功事件

                    //所有文件上传结束事件
                    onUploadFinished: function () {
                        layer.closeAll('loading');
                    }
                });
            },

        };
    })();

    module.exports = vueComponent;
});