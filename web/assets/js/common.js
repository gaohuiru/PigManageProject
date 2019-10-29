/**
 * 删除疫苗判断参数设定
 * @param a
 * @author 陈洪彬
 */
function deleteIllnessSetList(a) {
    var value = a.value;
    window.location.href = "/IllnessSetList/PigService/delete/illSetList.do?pigVarietyId="+value;
    window.setTimeout(function(){
        window.location.href = "/IllnessSetList/PigService/select/illSetList.do";
    },20);
}
