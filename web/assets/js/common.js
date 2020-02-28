/**
 * 删除疫苗判断参数设定
 * @param a
 * @author 陈洪彬
 */
function deleteIllnessSetList(a) {
    var pigVarietyId = a.value;
    var growthStage = a.name;
    window.location.href = "/IllnessSetList/PigService/delete/illSetList.do?pigVarietyId="+pigVarietyId+"&growthStage="+growthStage;
    window.setTimeout(function(){
        window.location.href = "/IllnessSetList/PigService/select/illSetList.do";
    },20);
}

/**
 * 跳转到疫苗判断参数设定界面并查询数据填入输入框中
 * @param e
 */
function updateIllnessSetList(e) {
    var pigVarietyId = e.value;
    var growthStage = e.name;
    window.location.href = "/UpdateIllnessSet/PigService/select/illSetList.do?pigVarietyId="+pigVarietyId+"&growthStage="+growthStage;
}

/**
 * 疫苗判断参数设定的条件查询
 */
function searchIllnessSet(){
    var criteria = document.getElementById("search-criteria").value;
    var content = document.getElementById("search-content").value;
    if (content=="白猪"||content=="哺乳阶段"){
        content=1;
    }else if (content=="黑猪"||content=="保育阶段"){
        content=2;
    }else if (content=="花猪"||content=="生长育肥阶段"){
        content=3;
    }
    window.location.href = "/IllnessSetList/PigService/select/illSetList.do?"+criteria+"="+content;
}

/**
 * 跳转回列表页面
 * @param e
 */
function IllnessSetList() {
    window.setTimeout(function(){
        window.location.href = "/IllnessSetList/PigService/select/illSetList.do";
    },20);
}
//if判断不太好
function  search(a) {
    var criteria = document.getElementById("search-criteria").value;
    var content = document.getElementById("search-content").value;
    var viewTable=a.value;
    if("pigInfos"==(viewTable)){
        window.location.href = "/pigInfoList/PigService/select/"+viewTable+".do?"+criteria+"="+content;
    }
    if("pigVariety"==viewTable){
        window.location.href = "/pigVarietyList/PigService/select/"+viewTable+".do?"+criteria+"="+content;
    }

}
function selectPigInfoList(){
    window.setTimeout(function(){
        window.location.href = "/pigInfoList/PigService/select/pigInfos.do?";
    },20);
}
function insertForPig(a) {
    var viewTable=a.value;
    if("pigVariety"==viewTable){
        window.location.href = "/pigVarietyInsert/PigService/select/pigVariety.do";
    }
    if("pigInfo"==viewTable){
        window.location.href = "/pigInfoInsert/PigService/select/pigInfo.do";
    }
    if("feedStandard"==viewTable){
        window.location.href = "/feedStandardInsert/PigService/select/feedStandard.do";
    }

}
function deletePigInfoList(a){
    var value = a.value;
    window.location.href = "/pigInfoList/PigService/delete/pigInfo.do?pigNo="+value;
    selectPigInfoList();
}



function deletePigVarietyList(a){
    var value = a.value;
    window.location.href = "/pigVarietyList/PigService/delete/pigVariety.do?pigVarietyId="+value;
    selectPigVarietyList();
}
function selectPigVarietyList () {
    window.setTimeout(function(){
        window.location.href = "/pigVarietyList/PigService/select/pigVariety.do";
    },20);
}
function selectFeedStandardList () {
    window.setTimeout(function(){
        window.location.href = "/feedStandardList/PigService/select/feedStandard.do";
    },20);
}






function selectPigFeedList () {
    window.setTimeout(function(){
        window.location.href = "/pigFeedList/PigService/select/pigFeed.do";
    },20);
}
function deletePigFeedList(a){
    var value = a.value;
    window.location.href = "/pigFeedList/PigService/delete/pigFeed.do?id="+value;
    selectPigFeedList();
}