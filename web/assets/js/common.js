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
    window.location.href = "/UpdateIllnessSet/PigService/select/illSetList.do?pigVarietyId="+pigVarietyId;
}
function searchIllnessSet(){
    var criteria = document.getElementById("search-criteria").value;
    var content = document.getElementById("search-content").value;
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

function  search() {
    var criteria = document.getElementById("search-criteria").value;
    var content = document.getElementById("search-content").value;
    window.location.href = "/pigInfoList/PigService/select/pigInfo.do?"+criteria+"="+content;
}
function selectPigInfoList(){
    window.setTimeout(function(){
        window.location.href = "/pigInfoList/PigService/select/pigInfos.do?";
    },20);
}
function insertPigInfoList() {
    window.location.href = "/pigInfoInsert/PigService/select/pigInfo.do";
}
function deletePigInfoList(a){
    var value = a.value;
    window.location.href = "/pigInfoList/PigService/delete/pigInfo.do?pigNo="+value;
    selectPigInfoList();
}

