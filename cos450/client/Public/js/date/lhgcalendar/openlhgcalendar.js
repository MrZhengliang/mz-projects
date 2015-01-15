/*弹出居中的窗口*/
function opcal2()
{
	J.calendar.Show();
}

function opcal()
{
	J('#startDate').calendar({btnBar:false,format:'yyyyMMdd'});
	J('#endDate').calendar({btnBar:false,format:'yyyyMMdd'});
}
