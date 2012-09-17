No3b.popularity = (function(){

    var minegishi = "Minegishi Minami";
    var kojiharu = "Kojima Haruna";
    var takamina = "Takahashi Minami";

    function popularity(member) {
        $.ajax({
            url: "dashboard/getPopularity",
            data: "member="+member,
            success: function(data){
                assignText(data, member)
            }
        });
    }

    function minegishiClick() {
        popularity(minegishi)
    }

    function kojiharuClick() {
        popularity(kojiharu)
    }

    function takaminaClick() {
        popularity(takamina)
    }

    function assignText(data, member) {
        if(member == minegishi) {
            $('#minegishi-text').text(data)
        }

        if(member == kojiharu) {
            $('#kojiharu-text').text(data)
        }

        if(member == takamina) {
            $('#takamina-text').text(data)
        }
    }

    function init(){
        $('#minegishi-popularity-button').click(minegishiClick);
        $('#kojiharu-popularity-button').click(kojiharuClick);
        $('#takamina-popularity-button').click(takaminaClick);
    }

    return {
        init : init
    };

}());

$(document).ready(No3b.popularity.init);