<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.highcharts.com/highcharts.js"></script> <!-- Highcharts ���̺귯�� -->

</head>
<style>
    #container {
        width: 400px;
        height: 330px;
    }
</style>

<body>
    <div id="container">

    </div>

    <script>
        const chart = Highcharts.chart('container', {
            chart: {
                animation: false, // �ִϸ��̼� ��Ȱ��ȭ
                events: {
                    load: function () {
                        const series = this.series[0];
                        let second = 1;
                        const interval = setInterval(function () {
                            if (second <= 180) {
                                // 180�ʱ��� 250���� �ö�
                                var temp = (250 - 50) / 180 * second + 50;
                            } else if (second <= 240) {
                                // 180�ʺ��� 240�ʱ��� ������ �����Ͽ� 100���� ����
                                var temp = - (150 / 60) * (second - 180) + 250;
                            } else {
                                clearInterval(interval);
                            }

                            series.addPoint([second, temp], true, false);
                            second++;
                        }, 3000); // 3�ʸ��� ������Ʈ
                    }
                }
            },
            title: {
                text: '���÷ο� �µ� �׷���'
            },
            xAxis: {
                type: 'linear',
                title: {
                    text: '�ð� (��)'
                },
                tickInterval: 30 // 30�� �������� ǥ��
            },
            yAxis: {
                title: {
                    text: '�µ� (��C)'
                },
                min: 0,
                max: 250,
                tickInterval: 50
            },
            series: [{
                name: '�µ�',
                data: [] // �ʱ� �����ʹ� �����
            }]
        });
    </script>
</body>

</html>